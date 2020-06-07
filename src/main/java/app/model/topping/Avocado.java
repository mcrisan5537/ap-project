package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Avocado extends Topping {

    public Avocado() {
    }

    public Avocado(Food dish) throws ToppingCostException {
        super(dish);
    }

}
