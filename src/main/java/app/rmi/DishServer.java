package app.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DishServer extends Thread {

    @Override

    public void run() {
        try {
            Registry registry = LocateRegistry.createRegistry(12345);
            registry.bind("foodservice", new DishServiceImplementation());
        } catch(RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

}
