
package swing;

import UI.ImageViewer;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import model.Image;


public class ImagePanel extends JPanel implements ImageViewer{

    private Image image;
    private int offset;

    public void display (Image image){
        this.image = image;
        repaint();
    }
    
    public ImagePanel(){
        this.offset = 0;
    }
        
    @Override
    public void setImage(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    public Image getImage() {
        return image;
    }
    
    public void paint(Graphics graphics){
        if (image == null) return;
        super.paint(graphics);
        graphics.drawImage(getBitmap(), offset, 0, null);
        if (offset == 0) return;
        if (offset > 0) graphics.drawImage(getBufferedImage((SwingBitMap) 
                image.getprevImage().getBitmap()), offset - image.getBitmap().getWidth(), 0, null);   
        if (offset < 0) graphics.drawImage(getBufferedImage((SwingBitMap) 
                image.getnextImage().getBitmap()), image.getBitmap().getWidth() + offset, 0, null);
    }
    
    public BufferedImage getBufferedImage (SwingBitMap swingBitmap){
        return swingBitmap.getBufferedImage();
    }
    
    public BufferedImage getBitmap(){
        if (image.getBitmap() instanceof SwingBitMap)
            return getBufferedImage((SwingBitMap) image.getBitmap());
        return null;
    }    
}