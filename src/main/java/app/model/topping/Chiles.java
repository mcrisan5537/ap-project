package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Chiles extends Topping {

    public Chiles() {
    }

    public Chiles(Food dish) throws ToppingCostException {
        super(dish);
    }
}
