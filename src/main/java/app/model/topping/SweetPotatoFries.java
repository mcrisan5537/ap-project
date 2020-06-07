package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class SweetPotatoFries extends Topping {

    public SweetPotatoFries() {
    }

    public SweetPotatoFries(Food dish) throws ToppingCostException {
        super(dish);
    }
}
