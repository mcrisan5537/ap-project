package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Mushroom extends Topping {

    public Mushroom() {
    }

    public Mushroom(Food dish) throws ToppingCostException {
        super(dish);
    }
}
