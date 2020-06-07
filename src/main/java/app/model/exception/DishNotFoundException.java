package app.model.exception;

public class DishNotFoundException extends Exception {

    public DishNotFoundException() {
        super("Invalid dish specified.");
    }

    public DishNotFoundException(String message) {
        super(message);
    }

    public DishNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
