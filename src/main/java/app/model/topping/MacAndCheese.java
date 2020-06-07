package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class MacAndCheese extends Topping {

    public MacAndCheese() {
    }

    public MacAndCheese(Food dish) throws ToppingCostException {
        super(dish);
    }
}
