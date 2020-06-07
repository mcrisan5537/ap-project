package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Tomato extends Topping {

    public Tomato() {
    }

    public Tomato(Food dish) throws ToppingCostException {
        super(dish);
    }
}
