package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Egg extends Topping {

    public Egg() {
    }

    public Egg(Food dish) throws ToppingCostException {
        super(dish);
    }
}
