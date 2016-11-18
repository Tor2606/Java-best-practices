package FactoryPatternExample;

public class Hat implements Clothes{

    @Override
    public void print() {
        System.out.println("This is hat!");
    }
}
