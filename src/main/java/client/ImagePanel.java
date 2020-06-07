package client;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.net.URL;

public class ImagePanel extends JPanel {

    private Image image;

    public ImagePanel() {
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(1280, 720));
    }

    public void setImage(BufferedImage image) {
        this.image = image.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        this.paintComponent(this.getGraphics());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
