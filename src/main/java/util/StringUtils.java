package util;

import app.model.Dish;
import app.model.topping.Topping;

import java.util.List;

public class StringUtils {

    public static String capitalizeString(String string) {
        string = string.substring(0, 1).toUpperCase() +
                string.substring(1).toLowerCase();
        return string;
    }

    public static String joinCapitalizedStrings(String[] strings) {
        StringBuilder returnString = new StringBuilder();
        for(String string : strings)
            returnString.append(capitalizeString(string));
        return returnString.toString();
    }

    public static String separateByUppercase(String string) {
        StringBuilder sb = new StringBuilder();

        int length = string.length();
        for(int i = 1; i < string.length(); i++) {
            if(Character.isUpperCase(string.codePointAt(i))) {
                sb.append(string.substring(0, i)).append(" ");
                string = string.substring(i);
                i = 0;
                length = string.length();
            }
        }
        sb.append(string.substring(0));

        return sb.toString();
    }

    private static String getSeparatedString(List<Topping> topping) {
        return topping.stream()
                .map(Topping::toString)
                .reduce((t1, t2) -> t1 + " " + t2)
                .orElse("");
    }

    public static String getQueryString(Dish dish) {
        String string = dish.getClass().getSimpleName() + " " + getSeparatedString(dish.getToppings());
        return string.replace(" ", "%20");
    }

}
