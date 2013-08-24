package org.powerbot.paint;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class PaintUtilities {

    private Image image;

    public PaintUtilities() {
        try {
            image = ImageIO.read(new URL("http://goo.gl/RR03OQ"));
        } catch (IOException ex) {
            Logger.getLogger(PaintUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Image getImage() {
        return image;
    }
}
