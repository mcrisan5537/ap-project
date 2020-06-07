package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Ham extends Topping {

    public Ham() {
    }

    public Ham(Food food) throws ToppingCostException {
        super(food);
    }
}
