package app.model;

import app.model.exception.InvalidCostException;
import app.model.exception.ToppingCostException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Pizza extends Dish {

    public Pizza() {
        super();
        this.setDishCost(3.49);
    }

}
