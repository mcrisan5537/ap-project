package app.model;

import app.model.exception.InvalidCostException;
import app.model.exception.ToppingCostException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ToppingCost {

    private static Properties properties;

    private ToppingCost() {}

    public static Double get(String topping) throws ToppingCostException {
        if(properties == null) {
            try {
                properties = new Properties();
                properties.load(new FileReader("target/classes/toppings_cost.properties"));
            } catch(IOException e) {
                throw new ToppingCostException();
            }
        }
        try {
            Double cost = Double.parseDouble(properties.getProperty(topping));
        } catch(Exception e) {
            throw new InvalidCostException("Error reading cost from topping cost file.", e);
        }
        return Double.parseDouble(properties.getProperty(topping));
    }

}
