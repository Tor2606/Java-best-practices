package Patterns.StrategyPatern.StrategyPatternV2;

public class PaypallStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Payed with Paypal: $" + amount);
    }
}
