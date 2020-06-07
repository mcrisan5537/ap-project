package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Cheetos extends Topping {

    public Cheetos() {
    }

    public Cheetos(Food dish) throws ToppingCostException {
        super(dish);
    }
}
