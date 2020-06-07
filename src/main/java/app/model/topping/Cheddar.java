package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Cheddar extends Topping {

    public Cheddar() {
    }

    public Cheddar(Food dish) throws ToppingCostException {
        super(dish);
    }
}
