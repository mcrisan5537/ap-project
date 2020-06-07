package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Mustard extends Topping {

    public Mustard() {
    }

    public Mustard(Food dish) throws ToppingCostException {
        super(dish);
    }
}
