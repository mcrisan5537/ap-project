package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Mayonnaise extends Topping {

    public Mayonnaise() {
    }

    public Mayonnaise(Food dish) throws ToppingCostException {
        super(dish);
    }

}
