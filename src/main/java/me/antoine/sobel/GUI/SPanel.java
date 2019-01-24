package me.antoine.sobel.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SPanel extends JPanel {
    private BufferedImage sobel;

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

        g.drawImage(sobel, 0, 0, null);
    }
}
