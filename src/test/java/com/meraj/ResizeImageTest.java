package com.meraj;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class ResizeImageTest {

    private ResizeImage resizeImage;

    @Before
    public void setUp() {
        resizeImage = new ResizeImage();
    }

    @Test
    public void resizeImage() throws IOException {
        final URL imageStream = getClass().getClassLoader().getResource("cat.jpeg");
        final BufferedImage actualImage = ImageIO.read(imageStream);
        assertEquals(318, actualImage.getWidth());
        assertEquals(159, actualImage.getHeight());
        final byte[] imageBytes = IOUtils.toByteArray(imageStream);
        final BufferedImage resizedImage = this.resizeImage.resizeImage(imageBytes, 250, 140);
        assertEquals(250, resizedImage.getWidth());
        assertEquals(140, resizedImage.getHeight());
    }
}