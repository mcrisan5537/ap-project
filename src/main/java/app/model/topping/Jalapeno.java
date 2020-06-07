package app.model.topping;

import app.model.Dish;
import app.model.Food;
import app.model.exception.ToppingCostException;

public class Jalapeno extends Topping {

    public Jalapeno() {
    }

    public Jalapeno(Food dish) throws ToppingCostException {
        super(dish);
    }

}
