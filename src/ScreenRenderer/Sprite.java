package ScreenRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

/**
 * This is a class
 * Created 2021-05-04
 *
 * @author Magnus Silverdal
 */
public class Sprite {
    private int[] image;
    private Rectangle boundingBox;

    public Sprite(String imagePath, int x, int y) {
        try {
            // Read image and copy to get correct format (ARGB)
            BufferedImage marioImg = ImageIO.read(new File("supermario2.png"));
            BufferedImage marioImgARGB = new BufferedImage(marioImg.getWidth(), marioImg.getHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            marioImgARGB.getGraphics().drawImage(marioImg,0,0,null);
            image = ((DataBufferInt) marioImgARGB.getRaster().getDataBuffer()).getData();
            // Placement and collisionbox
            boundingBox = new Rectangle(x,y, marioImgARGB.getWidth(), marioImgARGB.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] getPixels() {
        return image;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }
}
