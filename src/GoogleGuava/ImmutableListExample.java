package GoogleGuava;

import GoogleGuava.Objects.Item;
import com.google.common.collect.ImmutableList;

/**
 * Created by islabukhin on 04.10.16.
 */
public class ImmutableListExample {
    private final ImmutableList<Item> immutableList;

    public ImmutableListExample(ImmutableList<Item> immutableList) {
        this.immutableList = ImmutableList.copyOf(immutableList);
    }

    public void printList(){
        immutableList.stream().forEach(el -> System.out.println(el.toString()));
    }

    public static void main(String[] args) {
        ImmutableList<Item> list = new ImmutableList.Builder<Item>().add(new Item("1","one")).add(new Item("2","two")).build();
        ImmutableListExample immutableListExample = new ImmutableListExample(list);
        immutableListExample.printList();
    }
}
