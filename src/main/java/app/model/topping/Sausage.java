package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Sausage extends Topping {

    public Sausage() {
    }

    public Sausage(Food dish) throws ToppingCostException {
        super(dish);
    }
}
