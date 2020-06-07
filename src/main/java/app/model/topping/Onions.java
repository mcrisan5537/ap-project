package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Onions extends Topping {

    public Onions() {
    }

    public Onions(Food dish) throws ToppingCostException {
        super(dish);
    }
}
