package app.model.exception;

public class InvalidCurrencyException extends Exception {

    public InvalidCurrencyException() {
        super("Invalid currency specified.");
    }

    public InvalidCurrencyException(String message) {
        super(message);
    }

    public InvalidCurrencyException(String message, Throwable cause) {
        super(message, cause);
    }
}
