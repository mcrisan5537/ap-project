package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Pickles extends Topping {

    public Pickles() {
    }

    public Pickles(Food dish) throws ToppingCostException {
        super(dish);
    }
}
