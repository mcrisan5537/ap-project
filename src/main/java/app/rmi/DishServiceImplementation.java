package app.rmi;

import app.Error;
import app.Response;
import app.model.Dish;
import app.model.Food;
import app.model.topping.Topping;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import util.StringUtils;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DishServiceImplementation extends UnicastRemoteObject implements DishService {

    private static Gson gson;

    protected DishServiceImplementation() throws RemoteException {
        super();
        gson = new Gson().newBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    }

    @Override
    public String addDish(Food food) throws Exception {
        URL url = new URL("http://localhost:8081/dishes");
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConnection = (HttpURLConnection)connection;

        httpConnection.setRequestMethod("POST");
        httpConnection.setDoOutput(true);
        httpConnection.setDoInput(true);
        httpConnection.setRequestProperty("Content-Type", "application/json");
        httpConnection.connect();

        String json = parseDish(food);
//        System.out.println(json);
        PrintWriter writer = new PrintWriter(httpConnection.getOutputStream());
        writer.println(json);
        writer.close();

        String returnString;
        if(httpConnection.getResponseCode() == 201) {
            Response response = gson.fromJson(new InputStreamReader(httpConnection.getInputStream()), Response.class);
            JsonObject responseTree = gson.toJsonTree(response).getAsJsonObject();
            responseTree.addProperty("success", true);
            returnString = gson.toJson(responseTree);
        } else {
            Error error = gson.fromJson(new InputStreamReader(httpConnection.getInputStream()), Error.class);
            JsonObject errorTree = gson.toJsonTree(error).getAsJsonObject();
            errorTree.addProperty("success", false);
            returnString = gson.toJson(errorTree);
        }
        httpConnection.disconnect();
        return returnString;
    }

    private static String parseDish(Food food) {
        JsonObject root = new JsonObject();
        JsonArray toppings = new JsonArray();

        Topping topping = (Topping) food;
        try {
            while(true) {
                String toppingName = topping.getClass().getSimpleName();
                toppings.add(StringUtils.separateByUppercase(toppingName));
                topping = (Topping)topping.getFood();
            }
        } catch(ClassCastException e) {}

        Dish dish = (Dish)topping.getFood();

        root.addProperty("type", dish.getClass().getSimpleName());
        root.add("toppings", toppings);

        return gson.newBuilder().setPrettyPrinting().create().toJson(root);
    }

}
