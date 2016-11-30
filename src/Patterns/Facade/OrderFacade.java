package Patterns.Facade;

public class OrderFacade {
    private Payment payment = new Payment();
    private Inventory inventory = new Inventory();

    public void placeOrder(String orderId){
        String step1 = inventory.checkInventory(orderId);
        String step2 = payment.deductPayment(orderId);
        System.out.println("Following steps completed: " + step1 + " & " + step2);
    }
}
