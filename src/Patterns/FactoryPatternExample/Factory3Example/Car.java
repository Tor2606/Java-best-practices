package Patterns.FactoryPatternExample.Factory3Example;

public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving car");
    }

    @Override
    public void clean() {
        System.out.println("Cleaning car");
    }
}
