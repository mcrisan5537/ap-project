package client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class ControlPanel extends JPanel {

    private JButton addFood;
    private JButton saveImage;
    private String imageURL;

    public ControlPanel() {
        imageURL = null;
        init();
    }

    private void init() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));

        addFood = new JButton("ADD FOOD");
        addFood.addActionListener(this::addFoodClicked);
        saveImage = new JButton("SAVE IMAGE");
        saveImage.addActionListener(this::saveImageClicked);

        add(addFood);
        add(saveImage);
    }

    private void saveImageClicked(ActionEvent actionEvent) {
        try {
//            System.out.println(imageURL);
            URL url = new URL(imageURL);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            InputStream reader = new BufferedInputStream(connection.getInputStream());
            reader.transferTo(new BufferedOutputStream(new FileOutputStream("image " + Math.random()*943559473 + ".jpeg")));
            reader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void addFoodClicked(ActionEvent actionEvent) {
        try {
            String json = App.getDishService().addDish(App.getMainFrame().getFoodSelector().getFood());
            JsonObject root = JsonParser.parseString(json).getAsJsonObject();
            if(root.getAsJsonPrimitive("success").getAsBoolean()) {
                imageURL = root.getAsJsonObject("imageLinks").getAsJsonPrimitive("full").getAsString();
                App.getMainFrame().getImagePanel().setImage(ImageIO.read(new URL(imageURL)));
            }
        } catch(Exception e) {
//            e.printStackTrace();
            System.err.println("Failed adding dish.");
        }
    }
}
