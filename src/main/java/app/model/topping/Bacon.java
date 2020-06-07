package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Bacon extends Topping {

    public Bacon() {
    }

    public Bacon(Food dish) throws ToppingCostException {
        super(dish);
    }
}
