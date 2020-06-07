package client;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private FoodSelector foodSelector;
    private ImagePanel imagePanel;
    private ControlPanel controlPanel;

    public MainFrame() throws HeadlessException {
        foodSelector = new FoodSelector();
        imagePanel = new ImagePanel();
        controlPanel = new ControlPanel();
        init();
    }

    private void init() {
        setTitle("Food Service");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        add(foodSelector, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public FoodSelector getFoodSelector() {
        return foodSelector;
    }

    public ImagePanel getImagePanel() {
        return imagePanel;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }
}
