
package model;


public class RealImage extends Image{
    
    private final BitMap bitMap;
    private Image prevImage;
    private Image nexImage;
   
    public RealImage(BitMap bitMap) {
        this.bitMap = bitMap;
    }

    @Override
    public Image getnextImage() {
        return nexImage;
    }

    @Override
    public Image getprevImage() {
        return prevImage;
    }

    @Override
    public BitMap getBitmap() {
        return bitMap;
    }

    @Override
    public void setPrev(Image image) {
        prevImage = image;
    }

    @Override
    public void setNext(Image image) {
        nexImage = image;
    }

    
    
}
