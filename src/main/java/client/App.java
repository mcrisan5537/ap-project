package client;

import app.model.Dish;
import app.model.Food;
import app.model.Pizza;
import app.model.topping.*;
import app.rmi.DishService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.URL;
import java.rmi.Naming;

public class App {

    private static DishService dishService;
    private static MainFrame mainFrame;

    public static void main(String[] args) throws Exception {
        dishService = (DishService)Naming.lookup("rmi://localhost:12345/foodservice");
        mainFrame = new MainFrame();

//        mainFrame.getImagePanel().setImage(ImageIO.read(new URL("https://images.unsplash.com/photo-1525426996102-52becb48ee14?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjE0MDI2NX0")));
//        Food food = new Ham(new Cheese(new Mushroom(new Pepperoni(new Pizza()))));
//        System.out.println(dishService.addDish(food));
    }

    public static String parseDish(Food food) {
        JsonObject root = new JsonObject();
        JsonArray toppings = new JsonArray();

        Topping topping = (Topping) food;
        try {
            while(true) {
                toppings.add(topping.getClass().getSimpleName());
                topping = (Topping)topping.getFood();
            }
        } catch(ClassCastException e) {}

        Dish dish = (Dish)topping.getFood();

        root.addProperty("type", dish.getClass().getSimpleName());
        root.add("toppings", toppings);

        return new Gson().newBuilder().setPrettyPrinting().create().toJson(root);
    }

    public static DishService getDishService() {
        return dishService;
    }

    public static MainFrame getMainFrame() {
        return mainFrame;
    }
}
