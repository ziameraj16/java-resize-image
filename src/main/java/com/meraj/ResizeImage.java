package com.meraj;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ResizeImage {

    public BufferedImage resizeImage(byte[] image, int newWidth, int newHeight) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(image));
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, bufferedImage.getType());
        Graphics2D graphics = resizedImage.createGraphics();
        graphics.drawImage(bufferedImage, 0, 0, newWidth, newHeight, null);
        graphics.dispose();

        return resizedImage;
    }
}
