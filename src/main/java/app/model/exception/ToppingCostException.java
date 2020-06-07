package app.model.exception;

public class ToppingCostException extends Exception {

    public ToppingCostException() {
        super("Error reading topping cost file.");
    }

    public ToppingCostException(String message) {
        super(message);
    }

    public ToppingCostException(String message, Throwable cause) {
        super(message, cause);
    }
}
