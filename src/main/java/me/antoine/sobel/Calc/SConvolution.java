package me.antoine.sobel.Calc;

import java.awt.image.BufferedImage;

public class SConvolution {
    private int[][] hKernel = { {1, 2, 1}, {0, 0, 0}, {-1, -2, -1} };
    private int[][] vKernel = { {-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1} };

    public BufferedImage convolve(BufferedImage image) {
    }
}
