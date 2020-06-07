package app.model.exception;

public class CurrencyAPIException extends RuntimeException {

    public CurrencyAPIException() {
        super("Can't realise connect to currency API");
    }

    public CurrencyAPIException(String message) {
        super(message);
    }

    public CurrencyAPIException(String message, Throwable cause) {
        super(message, cause);
    }
}
