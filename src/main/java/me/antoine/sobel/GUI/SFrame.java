package me.antoine.sobel.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class SFrame extends JFrame {
    public SFrame() {
        this.init();
    }

    private void init() {
        this.setTitle("Sobel");
        BufferedImage sobel = this.readFile("car.jpg");
        SPanel panel = new SPanel(sobel);
        this.add(panel);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private BufferedImage readFile(String path) {
        ClassLoader loader = this.getClass().getClassLoader();
        BufferedImage image = null;

        try {
            InputStream stream = loader.getResourceAsStream(path);

            image = ImageIO.read(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }
}
