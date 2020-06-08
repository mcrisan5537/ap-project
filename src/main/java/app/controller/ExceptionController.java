package app.controller;

import app.Error;
import app.model.exception.DishNotFoundException;
import app.model.exception.InvalidCurrencyException;
import app.model.exception.ToppingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler({DishNotFoundException.class, ToppingNotFoundException.class})
    public ResponseEntity<Error> handleDish(Exception e) {
        Error error = new Error("Request body may be incorrect.", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidCurrencyException.class})
    public ResponseEntity<app.Error> handleInvalidCurrency(Exception e) {
        Error error = new Error("Specified currency is not available.", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Error> handleGenericError(Exception e) {
        Error error = new Error("Unknown error.", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
