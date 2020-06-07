package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class BbqSauce extends Topping {

    public BbqSauce() {
    }

    public BbqSauce(Food dish) throws ToppingCostException {
        super(dish);
    }
}
