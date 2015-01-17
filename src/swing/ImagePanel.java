
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
    
    public void paint(Graphics g){
        if (image == null) return;
        super.paint(g);
        //g.drawImage(getBitMap(), offset, 0, null);
        g.drawImage(getBitMap(), 0, 0, this.getWidth(), this.getHeight(), null);
    }
    
    public BufferedImage getBufferedImage (SwingBitMap swingBitmap){
        return swingBitmap.getBufferedImage();
    }
    
    public BufferedImage getBitMap(){
        if (image.getBitmap() instanceof SwingBitMap)
            return getBufferedImage((SwingBitMap) image.getBitmap());
        return null;
    }    
}