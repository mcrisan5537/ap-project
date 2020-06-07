package app.model.topping;

import app.model.Food;
import app.model.ToppingCost;
import app.model.exception.InvalidCostException;
import app.model.exception.ToppingCostException;
import org.springframework.data.annotation.Transient;
import util.StringUtils;

public abstract class Topping implements Food {

    @Transient
    private Food food;
    protected String name;
    protected Double cost;

    public Topping() {
    }

    public Topping(Food dish) throws ToppingCostException {
        this.mapCost();
        this.name = StringUtils.separateByUppercase(this.getClass().getSimpleName());
        this.food = dish;
    }

    public Food getFood() {
        return this.food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        if(cost < 0)
            throw new InvalidCostException();
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void mapCost() throws ToppingCostException {
        String toppingName = this.getClass().getSimpleName().toLowerCase();
        Double cost = ToppingCost.get(toppingName);
        this.setCost(cost);
    }

    @Override
    public String toString() {
        return StringUtils.separateByUppercase(this.getClass().getSimpleName());
    }

}
