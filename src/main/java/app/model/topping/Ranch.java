package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Ranch extends Topping {

    public Ranch() {
    }

    public Ranch(Food dish) throws ToppingCostException {
        super(dish);
    }
}
