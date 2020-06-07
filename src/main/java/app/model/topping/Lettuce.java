package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Lettuce extends Topping {

    public Lettuce() {
    }

    public Lettuce(Food food) throws ToppingCostException {
        super(food);
    }
}
