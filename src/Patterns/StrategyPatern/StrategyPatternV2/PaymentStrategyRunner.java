package Patterns.StrategyPatern.StrategyPatternV2;

public class PaymentStrategyRunner {
    public static void main(String[] args) {
        PaymentStrategy mainStrategy = new CreditCardStrategy("My card", "777", "1234 1234 1232 1233");
        someActionPlusPayment(mainStrategy);//in strategy we pass strategy as argument
        mainStrategy = new PaypallStrategy();
        someActionPlusPayment(mainStrategy);
    }

    private static void someActionPlusPayment(PaymentStrategy strategy){
        System.out.println("You need to pay!!");
        int amount = (int) (Math.random()*1000);
        strategy.pay(amount);
    }
}
