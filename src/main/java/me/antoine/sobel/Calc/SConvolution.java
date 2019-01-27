package me.antoine.sobel.Calc;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SConvolution {
    private int[][] hKernel = { {-1, -2, -1}, {0, 0, 0}, {1, 2, 1} };
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

                int magnitude = (int) Math.sqrt(horizontal * horizontal + vertical * vertical);

                if (magnitude > 255)
                    magnitude = 255;
                else if (magnitude < 0)
                    magnitude = 0;

                int pixel = 0xff000000 | (magnitude << 16) | (magnitude << 8) | magnitude;

                image.setRGB(x - 1, y - 1, pixel);
            }
        }
    }

    private int hadamardProduct(int x, int y, BufferedImage image, int[][] kernel) {
        int product = 0;

        for (int j = 0, jj = 2; j < 3 && jj > -1; j++, jj--) {
            for (int i = 0, ii = 2; i < 3 && ii > -1; i++, ii--) {
                int pixel = (image.getRGB(x - 1 + i, y - 1 + j)) & 0xff;
                product += pixel * kernel[ii][jj];
            }
        }

        return product;
    }
}
