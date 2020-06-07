package app;

import app.model.*;
import app.model.topping.*;
import app.rmi.DishServer;
import app.rmi.DishServiceImplementation;
import com.google.gson.Gson;
import org.bson.types.ObjectId;
import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import util.StringUtils;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.MonetaryConversions;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Locale;
import java.util.Currency;
import java.util.Properties;
import java.util.ResourceBundle;

@SpringBootApplication
public class App {

    public static void main(String[] args) throws Exception {

        new DishServer().start();
        SpringApplication.run(App.class, args);
//        System.out.println(new HotSauce(new Burger()).getCost());

//        ResourceBundle rs = ResourceBundle.getBundle("strings", new Locale("de"));
//        System.out.println(rs.getLocale());
//        String newToppingClassName = StringUtils.joinCapitalizedStrings("ketchup".split(" "));
//        System.out.println(newToppingClassName);
//

//        Food food = new Ham(new Lettuce(new Burger()));

//        System.out.println(CurrencyConverter.get(1.0, "RON"));
//        Locale locale = new Locale("en", "US");
//        CurrencyUnit unit = Monetary.getCurrency(locale);
//        MonetaryAmount amount = Monetary.getDefaultAmountFactory()
//                .setCurrency(unit)
//                .setNumber(100)
//                .create();
//        System.out.println(amount.getNumber());

//        System.out.println(CurrencyConverter.get(5, "RON"));

//        Locale locale = new Locale("ro");
//        System.out.println(StringsBundle.get(locale, "pineapple"));

//        System.out.println(new Gson().toJson(null));
//        Properties properties = new Properties();
//        properties.load(new FileReader("target/classes/toppings_cost.properties"));
//        System.out.println(properties.getProperty("dasdsa"));
//        System.out.println(Double.parseDouble(properties.getProperty("dsadsa")));

//        System.out.println(ImageSearch.getImageURL("hamburger"));

//        Properties properties = new Properties();
//        properties.load(new FileReader("../application.properties"));
//        System.out.println(new DishCollection().getPort());
//        Dish dish = Dish.createDish("Burger", Arrays.asList("salsa", "monterey jack cheese"));
//        System.out.println(dish);
//        System.out.println(ArrayIndexOutOfBoundsException.class.getCanonicalName());
//        Class clazz = Class.forName("app.model.Food");
//        Food food = (Food)clazz.getConstructor(Integer.class, String.class).newInstance(Integer.valueOf(1), "pizza");
//        Food food = new Cheese(new Mushroom(new Pepperoni(new Pizza())));
//        parseDish(food);
    }

}
