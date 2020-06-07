package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class HotSauce extends Topping {

    public HotSauce() {
    }

    public HotSauce(Food dish) throws ToppingCostException {
        super(dish);
    }

}
