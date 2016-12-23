package Patterns.FactoryPatternExample.Factory3Example;

public class Bus implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving bus");
    }

    @Override
    public void clean() {
        System.out.println("Cleaning bus");
    }
}
