package app.model;

import java.util.*;

public class StringsBundle {

    private static Map<Locale, ResourceBundle> resourceBundles;

    private StringsBundle() {
    }

    public static String get(Locale locale, String string) {
        if(resourceBundles == null) {
            resourceBundles = new HashMap<>();
        }
        if(resourceBundles.get(locale) == null) {
            resourceBundles.put(locale, ResourceBundle.getBundle("strings", locale));
        }

        return resourceBundles.get(locale).getString(string.toLowerCase().replace(" ", ""));
    }

}
