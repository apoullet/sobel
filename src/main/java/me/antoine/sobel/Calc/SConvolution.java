package me.antoine.sobel.Calc;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SConvolution {
    private int[][] hKernel = { {1, 2, 1}, {0, 0, 0}, {-1, -2, -1} };
    private int[][] vKernel = { {-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1} };

    public void convolve(BufferedImage image) {
        BufferedImage buffer = new BufferedImage(image.getWidth() + 2, image.getHeight() + 2, BufferedImage.TYPE_BYTE_GRAY);
        Graphics imageGraphics = buffer.getGraphics();
        imageGraphics.drawImage(image, 1, 1, null);
        imageGraphics.dispose();

        for (int y = 1; y < buffer.getHeight() - 1; y++) {
            for (int x = 1; x < buffer.getWidth() - 1; x++) {
                int horizontal = this.hadamardProduct(x, y, buffer, vKernel);
                int vertical = this.hadamardProduct(x, y, buffer, hKernel);

                int magnitude = (int) Math.sqrt(Math.pow(horizontal, 2) + Math.pow(vertical, 2));

                image.setRGB(x - 1, y - 1, magnitude);
            }
        }
    }

    private int hadamardProduct(int x, int y, BufferedImage image, int[][] kernel) {
        int product = 0;

        for (int j = 0, jj = 2; j < 3 && jj > -1; j++, jj--) {
            for (int i = 0, ii = 2; i < 3 && ii > -1; i++, ii--) {
                product += image.getRGB(x - 1 + i, y - 1 + j) * kernel[ii][jj];
            }
        }

        return product;
    }
}
