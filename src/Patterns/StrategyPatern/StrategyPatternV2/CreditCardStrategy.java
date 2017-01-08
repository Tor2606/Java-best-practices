package Patterns.StrategyPatern.StrategyPatternV2;

public class CreditCardStrategy implements PaymentStrategy {

    private String name;
    private String cvv;
    private String number;

    public CreditCardStrategy(String name, String cvv, String number) {
        this.name = name;
        this.cvv = cvv;
        this.number = number;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "$ payed from " + this.name + "credit card!");
    }
}
