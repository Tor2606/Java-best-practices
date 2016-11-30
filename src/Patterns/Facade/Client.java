package Patterns.Facade;

public class Client {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.placeOrder("OR12345");
        System.out.println("Order processing completed");
    }
}
