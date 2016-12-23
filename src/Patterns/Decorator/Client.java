package Patterns.Decorator;

public class Client {
    public static void main(String[] args) {
    Pizza pizza = new ChickenTikkaPizza( new BasicPizza());
    System.out.println(pizza.bakePizza());}
}
