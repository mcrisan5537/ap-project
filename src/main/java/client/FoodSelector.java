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

    private Food food;

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
        } catch(Exception e) {}
    }

    private void toppingButtonClick(ActionEvent actionEvent) {
        String toppingName = toppingField.getText();
        toppingName = StringUtils.joinCapitalizedStrings(toppingName.split(" "));
        try {
            Class clazz = Class.forName("app.model.topping." + toppingName);
            Constructor constructor = clazz.getConstructor(Food.class);
            food = (Food)constructor.newInstance(food);
        } catch(Exception e) {}
//        System.out.println(App.parseDish(food));
    }

    public Food getFood() {
        return food;
    }
}
