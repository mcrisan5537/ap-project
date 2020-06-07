package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class PepperJack extends Topping {

    public PepperJack() {
    }

    public PepperJack(Food dish) throws ToppingCostException {
        super(dish);
    }

}
