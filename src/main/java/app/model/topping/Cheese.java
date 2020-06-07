package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Cheese extends Topping  {

    public Cheese() {
    }

    public Cheese(Food dish) throws ToppingCostException {
        super(dish);
    }
}
