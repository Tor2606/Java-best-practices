package Patterns.ProxyDesignPattern.ProtetionProxyExample;

public class RealInternetAccess implements InternetAccess {
    private String employeeName = null;

    public RealInternetAccess(String employeeName){
        this.employeeName = employeeName;
    }

    @Override
    public void grantInternetAccess() {
        System.out.println("Internet Access granted for employee: " +
         employeeName);
    }
}
