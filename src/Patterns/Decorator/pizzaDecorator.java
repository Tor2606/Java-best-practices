package Patterns.Decorator;

public abstract class PizzaDecorator implements Pizza {
    Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String bakePizza(){
       return pizza.bakePizza();
    }
}
