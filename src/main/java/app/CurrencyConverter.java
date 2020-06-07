package app;

import app.model.exception.CurrencyAPIException;
import app.model.exception.InvalidCurrencyException;
import com.google.gson.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

    private static Map<String, Double> currency;

    private CurrencyConverter() {}

    public static Double get(Double amount, String to) throws InvalidCurrencyException {
        if(currency == null) {
            currency = new HashMap<>();
            refresh();
        }
        try {
            return amount * currency.get(to.toUpperCase());
        } catch(NullPointerException e) {
            throw new InvalidCurrencyException();
        }
    }

    private static void refresh() {
        try {
            URL url = new URL("https://api.exchangeratesapi.io/latest?base=USD");
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            JsonObject rates = JsonParser.parseReader(bufferedReader).getAsJsonObject().getAsJsonObject("rates");
            for(String curr : rates.keySet())
                currency.put(curr, rates.getAsJsonPrimitive(curr).getAsDouble());
        } catch(Exception e) {
            throw new CurrencyAPIException("Can't realise connection to API.", e);
        }
    }

}
