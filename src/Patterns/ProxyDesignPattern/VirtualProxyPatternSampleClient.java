package Patterns.ProxyDesignPattern;

public class VirtualProxyPatternSampleClient {

    //Using the proxy we can avoid multiple loading of the image(also it reduce memory usage when image showing is unnecessary)
    public static void main(String[] args) {
        final Image img1 = new ProxyImage("file1");
        final Image img2 = new ProxyImage("file2");

        img1.showImage();
        img2.showImage();
    }

}
