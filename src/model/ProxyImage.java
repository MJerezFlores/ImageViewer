
package model;

import persistence.ImageLoader;


public class ProxyImage extends Image{

    private Image nextImage;
    private Image prevImage;
    private Image realImage;
    private final ImageLoader imageLoader;

    public ProxyImage(ImageLoader loader) {
        this.imageLoader = loader;
    }

    @Override
    public BitMap getBitmap() {
        checkLoaded();
        return realImage.getBitmap();
    }
    
    private void checkLoaded(){
        if (realImage != null) return;
        realImage = imageLoader.load();
    }

    @Override
    public Image getnextImage() {
        return nextImage;
    }

    @Override
    public Image getprevImage() {
        return prevImage;
    }

    @Override
    public void setPrev(Image image) {
        this.prevImage = image;
    }

    @Override
    public void setNext(Image image) {
        this.nextImage = image;
    }

}
