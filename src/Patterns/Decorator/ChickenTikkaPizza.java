package Patterns.Decorator;

public class ChickenTikkaPizza extends PizzaDecorator {
    public ChickenTikkaPizza(Pizza pizza) {
        super(pizza);
    }

    public String bakePizza() {
        return pizza.bakePizza() + " with chicken topping added!";
    }
}
