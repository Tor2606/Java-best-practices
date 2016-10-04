package GoogleGuava.Iterables;

import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by islabukhin on 04.10.16.
 */
public class IterablesSample {
    // Concatenating two separate collections and performing operations on the result can
    // cause a quite a lot of clutter. Iterables to the rescue. Take a minute and think how
    // code might look without Iterables.concat.
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("a");
        list2.add("b");
        for (String it : Iterables.concat(list1,list2)) {
            System.out.println(it);
        }
    }
}
