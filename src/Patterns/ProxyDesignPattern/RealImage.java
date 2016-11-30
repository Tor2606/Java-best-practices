package Patterns.ProxyDesignPattern;

public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void showImage() {
        System.out.println("Show image " + fileName);
    }
}
