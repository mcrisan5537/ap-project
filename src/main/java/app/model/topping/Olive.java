package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Olive extends Topping {

    public Olive() {
    }

    public Olive(Food dish) throws ToppingCostException {
        super(dish);
    }
}
