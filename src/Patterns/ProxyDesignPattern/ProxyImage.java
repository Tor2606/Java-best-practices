package Patterns.ProxyDesignPattern;

public class ProxyImage implements Image {

    private RealImage realImage = null;
    private String fileName = null;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void showImage() {
        if(realImage==null){
            realImage=new RealImage(fileName);
        }
        realImage.showImage();
    }
}
