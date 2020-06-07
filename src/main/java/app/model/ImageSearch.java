package app.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.*;

public class ImageSearch {

    private static String APILink = "https://api.unsplash.com/photos/random?&client_id=U3Ske5xg-4Y5rSsTr-rcj2RZPEavfweTd-PL7Y_TIOc&query=";

    public static ImageLinks getImageLinksJson(String query) throws Exception {
        URL url = new URL(APILink + query);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        JsonObject URLs = JsonParser.parseReader(bufferedReader).getAsJsonObject().getAsJsonObject("urls");

        return new ImageLinks().builder()
                        .small(URLs.getAsJsonPrimitive("small").getAsString())
                        .regular(URLs.getAsJsonPrimitive("regular").getAsString())
                        .full(URLs.getAsJsonPrimitive("raw").getAsString())
                        .raw(URLs.getAsJsonPrimitive("full").getAsString())
                        .build();
    }

}
