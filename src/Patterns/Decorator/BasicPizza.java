package Patterns.Decorator;

public class BasicPizza implements Pizza{
    @Override
    public String bakePizza() {
        return "Basic Pizza";
    }
}
