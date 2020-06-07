package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Chicken extends Topping {

    public Chicken() {
    }

    public Chicken(Food dish) throws ToppingCostException {
        super(dish);
    }
}
