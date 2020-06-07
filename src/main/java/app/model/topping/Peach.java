package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Peach extends Topping {

    public Peach() {
    }

    public Peach(Food dish) throws ToppingCostException {
        super(dish);
    }
}
