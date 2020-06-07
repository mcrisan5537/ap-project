package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Salsa extends Topping {

    public Salsa() {
    }

    public Salsa(Food dish) throws ToppingCostException {
        super(dish);
    }

}
