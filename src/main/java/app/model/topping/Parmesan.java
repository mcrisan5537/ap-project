package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Parmesan extends Topping {

    public Parmesan() {
    }

    public Parmesan(Food dish) throws ToppingCostException {
        super(dish);
    }
}
