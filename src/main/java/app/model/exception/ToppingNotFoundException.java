package app.model.exception;

public class ToppingNotFoundException extends Exception {

    public ToppingNotFoundException() {
        super("Invalid topping specified");
    }

    public ToppingNotFoundException(String message) {
        super(message);
    }

    public ToppingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
