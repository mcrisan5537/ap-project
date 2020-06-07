package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Pesto extends Topping {

    public Pesto() {
    }

    public Pesto(Food dish) throws ToppingCostException {
        super(dish);
    }
}
