package Patterns.Visitor;

public interface ItemElement {
    public int accept(ShoppingCartVisitor visitor);
}
