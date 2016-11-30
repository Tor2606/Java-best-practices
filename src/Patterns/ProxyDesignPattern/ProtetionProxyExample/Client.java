package Patterns.ProxyDesignPattern.ProtetionProxyExample;

public class Client {
    public static void main(String[] args) {
        InternetAccess ia = new ProxyInternetAccess("Idiot_admin");
        ia.grantInternetAccess();
    }

}
