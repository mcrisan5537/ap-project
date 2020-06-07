package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Spinach extends Topping {

    public Spinach() {
    }

    public Spinach(Food dish) throws ToppingCostException {
        super(dish);
    }
}
