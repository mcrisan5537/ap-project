package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class MontereyJackCheese extends Topping {

    public MontereyJackCheese() {
    }

    public MontereyJackCheese(Food dish) throws ToppingCostException {
        super(dish);
    }

}
