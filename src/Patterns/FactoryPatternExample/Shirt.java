package Patterns.FactoryPatternExample;

public class Shirt implements Clothes {
    @Override
    public void print() {
        System.out.println("This is shirt!");
    }
}
