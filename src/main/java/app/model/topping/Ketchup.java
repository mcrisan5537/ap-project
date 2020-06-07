package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Ketchup extends Topping {

    public Ketchup() {
    }

    public Ketchup(Food dish) throws ToppingCostException {
        super(dish);
    }
}
