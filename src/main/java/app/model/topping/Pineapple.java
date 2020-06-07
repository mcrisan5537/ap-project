package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Pineapple extends Topping {

    public Pineapple() {
    }

    public Pineapple(Food dish) throws ToppingCostException {
        super(dish);
    }
}
