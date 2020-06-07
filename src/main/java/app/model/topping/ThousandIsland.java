package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class ThousandIsland extends Topping {

    public ThousandIsland() {
    }

    public ThousandIsland(Food dish) throws ToppingCostException {
        super(dish);
    }
}
