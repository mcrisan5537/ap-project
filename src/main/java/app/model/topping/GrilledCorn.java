package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class GrilledCorn extends Topping {

    public GrilledCorn() {
    }

    public GrilledCorn(Food dish) throws ToppingCostException {
        super(dish);
    }

}
