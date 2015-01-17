
package swing;

import java.awt.image.BufferedImage;
import model.BitMap;


public class SwingBitMap implements BitMap {

    private final BufferedImage bufferedImage;

    public SwingBitMap(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
    
    @Override
    public int getWidth() {
        return bufferedImage.getWidth();
    }

    @Override
    public int getHeight() {
        return bufferedImage.getHeight();
    }
     
}
