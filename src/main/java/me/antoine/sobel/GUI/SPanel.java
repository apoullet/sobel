package me.antoine.sobel.GUI;

import me.antoine.sobel.Calc.SConvolution;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SPanel extends JPanel {
    private BufferedImage sobel;

    public SPanel(BufferedImage image) {
        this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));

        this.sobel = image;

        SConvolution convolution = new SConvolution();

        convolution.convolve(sobel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(sobel, 0, 0, null);
    }
}
