package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Pepperoni extends Topping {

    public Pepperoni() {
    }

    public Pepperoni(Food dish) throws ToppingCostException {
        super(dish);
    }
}
