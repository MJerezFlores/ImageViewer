
package model;


public abstract class Image {
    
    public abstract Image getnextImage();
    public abstract Image getprevImage();
    public abstract BitMap getBitmap();
    public abstract void setPrev(Image image);
    public abstract void setNext(Image image);
    
}
