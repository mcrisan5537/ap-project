package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Chili extends Topping {

    public Chili() {
    }

    public Chili(Food dish) throws ToppingCostException {
        super(dish);
    }
}
