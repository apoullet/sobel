package me.antoine.sobel.GUI;

import javax.swing.*;
import java.awt.*;

public class SFrame extends JFrame {
    public SFrame() {
        this.init();
    }

    private void init() {
        this.setTitle("Sobel");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
