package app.rmi;

import app.model.Food;

import java.rmi.Remote;

public interface DishService extends Remote {

    String addDish(Food food) throws Exception;

}
