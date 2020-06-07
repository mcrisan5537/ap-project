package app.model.exception;

public class InvalidCostException extends RuntimeException {

    public InvalidCostException() {
        super("Invalid cost value.");
    }

    public InvalidCostException(String message) {
        super(message);
    }

    public InvalidCostException(String message, Throwable cause) {
        super(message, cause);
    }
}
