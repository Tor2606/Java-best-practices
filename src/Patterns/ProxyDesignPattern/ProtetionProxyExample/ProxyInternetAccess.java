package Patterns.ProxyDesignPattern.ProtetionProxyExample;

public class ProxyInternetAccess implements InternetAccess {

    private String employeeName = null;

    private RealInternetAccess realInternetAccess = null;

    private boolean access = false;

    public ProxyInternetAccess(String employeeName) {
        this.employeeName = employeeName;
        this.realInternetAccess = new RealInternetAccess(employeeName);
        if (employeeName.contains("admin")) {
            access = true;
        }
    }

    @Override
    public void grantInternetAccess() {
        if (access)
            realInternetAccess.grantInternetAccess();
    }
}
