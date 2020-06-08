package client;

import app.model.Dish;
import app.model.Food;
import app.model.topping.Topping;
import util.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Constructor;

public class FoodSelector extends JPanel {

    private Food food = null;

    private JLabel dishLabel;
    private JTextField dishField;

    private JLabel toppingLabel;
    private JTextField toppingField;

    private JButton dishButton;
    private JButton toppingButton;

    public FoodSelector() {
        init();
    }

    private void init() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));

        dishLabel = new JLabel("Dish:");
        dishField = new JTextField();
        dishField.setColumns(20);

        toppingLabel = new JLabel("Topping:");
        toppingField = new JTextField();
        toppingField.setColumns(20);

        dishButton = new JButton("SET DISH");
        dishButton.addActionListener(this::dishButtonClick);

        toppingButton = new JButton("ADD TOPPING");
        toppingButton.addActionListener(this::toppingButtonClick);

        add(dishLabel);
        add(dishField);
        add(toppingLabel);
        add(toppingField);
        add(dishButton);
        add(toppingButton);
    }

    private void dishButtonClick(ActionEvent ae) {
        String dishName = dishField.getText();
        dishName = StringUtils.capitalizeString(dishName);
        try {
            Class clazz = Class.forName("app.model." + dishName);
            Constructor constructor = clazz.getConstructor();
            food = (Dish)constructor.newInstance();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(App.getMainFrame(), "Dish not existent. \nPlease choose a dish from the set {pizza, burger}.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void toppingButtonClick(ActionEvent actionEvent) {
        String toppingName = toppingField.getText();
//        System.out.println(toppingName);
        toppingName = StringUtils.joinCapitalizedStrings(toppingName.split(" "));
//        System.out.println(toppingName);
        try {
            if(food == null) {
                JOptionPane.showMessageDialog(App.getMainFrame(), "Please set dish before adding any toppings.",
                                              "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Class clazz = Class.forName("app.model.topping." + toppingName);
                Constructor constructor = clazz.getConstructor(Food.class);
                food = (Food)constructor.newInstance(food);
            }
        } catch(NoClassDefFoundError | Exception e) {
            JOptionPane.showMessageDialog(App.getMainFrame(), "Topping not existent. \nPlease choose a known topping.",
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Food getFood() {
        return food;
    }
}
