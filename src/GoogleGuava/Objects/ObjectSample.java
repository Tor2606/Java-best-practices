package GoogleGuava.Objects;

/**
 * Created by islabukhin on 04.10.16.
 */
public class ObjectSample {

    //Objects makes it easy to implement hashcode/equals without
    // cluttering your classes too much
    public static void main(String[] args) {

        Item item1 = new Item("1", "first");
        Item item2 = new Item("2", "second");
        Item item3 = new Item("1", "first");
        System.out.println(item1 == item3);
        System.out.println(item1.equals(item3));
        System.out.println(item1.hashCode() == item3.hashCode());
        System.out.println(item2.equals(item1));
        System.out.println(item2.toString());
    }
}
