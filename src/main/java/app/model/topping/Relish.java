package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Relish extends Topping {

    public Relish() {
    }

    public Relish(Food dish) throws ToppingCostException {
        super(dish);
    }
}
