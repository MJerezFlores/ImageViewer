
package persistence;

import swing.SwingBitMap;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.Image;
import model.RealImage;


public class ImageLoader {
    private final String filename;

    public ImageLoader(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
    
    public Image load(){
        return new RealImage(new SwingBitMap(loadBufferedImage()));
    }
    
    private BufferedImage loadBufferedImage() {
        try {
            return ImageIO.read(new File(filename));
        } catch (IOException ex) {
            return null;
        }
    }
}
