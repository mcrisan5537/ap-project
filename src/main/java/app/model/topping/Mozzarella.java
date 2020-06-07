package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Mozzarella extends Topping {

    public Mozzarella() {
    }

    public Mozzarella(Food dish) throws ToppingCostException {
        super(dish);
    }
}
