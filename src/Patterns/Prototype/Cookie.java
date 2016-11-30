package Patterns.Prototype;

public class Cookie implements Cloneable {

    int weight;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Cookie)super.clone();
    }
}
