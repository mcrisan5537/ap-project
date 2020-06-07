package app.model;

import app.CurrencyConverter;
import app.model.exception.DishNotFoundException;
import app.model.exception.InvalidCostException;
import app.model.exception.InvalidCurrencyException;
import app.model.exception.ToppingNotFoundException;
import app.model.topping.Topping;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import util.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

@Document(collection = "dish")
public abstract class Dish implements Food {

    @Id
    private String id;
    private ObjectId objectId;
    private String dishName;
    private Double totalCost;
    private Double dishCost;
    private List<Topping> toppings = new ArrayList<>();
    private ImageLinks imageLinks;

    public Dish() {
        this.dishName = this.getClass().getSimpleName();
        this.totalCost = 0.0;
        this.dishCost = 0.0;
    }

    public static Dish createDish(String dishClassName, List<String> toppingsClassNames) throws DishNotFoundException, ToppingNotFoundException {
        String newDishClassName = StringUtils.capitalizeString(dishClassName);

        try {
            Class clazz = Class.forName("app.model." + newDishClassName);
            Constructor constructor = clazz.getConstructor();
            Dish dish = (Dish) constructor.newInstance();

            Double toppingsCost = 0.0;
            for(String toppingClassName : toppingsClassNames) {
                String newToppingClassName = StringUtils.joinCapitalizedStrings(toppingClassName.split(" "));
                try {
                    clazz = Class.forName("app.model.topping." + newToppingClassName);
                    constructor = clazz.getConstructor(Food.class);
                    Topping topping = (Topping) constructor.newInstance(dish);
                    toppingsCost += topping.getCost();
                    dish.addTopping(topping);
                } catch(ClassNotFoundException | NoSuchMethodException e) {
                    throw new ToppingNotFoundException("Invalid topping specified: " + toppingClassName, e);
                } catch(IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    throw new ToppingNotFoundException("Error creating topping: " + toppingClassName, e);
                }
            }

            dish.setTotalCost(dish.getDishCost() + toppingsCost);
            return dish;
        } catch(ClassNotFoundException | NoSuchMethodException e) {
            throw new DishNotFoundException("Invalid dish specified: " + dishClassName, e);
        } catch(IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new DishNotFoundException("Error creating dish: " + dishClassName, e);
        }
    }

    public void localize(String language, String currency) throws InvalidCurrencyException {
        if(language == null)
            language = "en";
        Locale locale = new Locale(language);

        this.setDishName(StringsBundle.get(locale, this.getDishName()));
        if(currency != null)
            this.setDishCost(CurrencyConverter.get(this.getDishCost(), currency));

        for(Topping topping : this.getToppings()) {
            topping.setName(StringsBundle.get(locale, topping.getName()));
            if(currency != null)
                topping.setCost(CurrencyConverter.get(topping.getCost(), currency));
        }
        this.refreshCost();
    }

    public void refreshCost() {
        Double toppingsCost = 0.0;
        for(Topping topping : toppings)
            toppingsCost += topping.getCost();

        this.setTotalCost(this.getDishCost() + toppingsCost);
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public boolean addTopping(Topping topping) {
        return this.toppings.add(topping);
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        if(totalCost < 0)
            throw new InvalidCostException();
        this.totalCost = totalCost;
    }

    public Double getDishCost() {
        return dishCost;
    }

    public void setDishCost(Double dishCost) {
        if(dishCost < 0)
            throw new InvalidCostException();
        this.dishCost = dishCost;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.id = objectId.toString();
        this.objectId = objectId;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Dish name: ").append(this.getClass().getSimpleName()).append("\n");
        sb.append("Toppings: ").append(this.toppings.toString()).append("\n");
        sb.append("Cost: ").append(this.getTotalCost()).append("\n");

        return sb.toString();
    }

}
