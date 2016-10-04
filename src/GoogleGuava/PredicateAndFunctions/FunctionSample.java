package GoogleGuava.PredicateAndFunctions;

import GoogleGuava.Objects.Item;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Created by islabukhin on 04.10.16.
 */
//Functions on the other hand, is a way of transforming one object to another. For example,
// convert concurrency on a order of items.

public class FunctionSample {
    Function currencyConverter = new Function<Item, String>() {
        @Override
        public String apply(Item item) {
            return item.getName().concat("converted");
        }
    };

    public static void main(String[] args) {
        FunctionSample functionSample = new FunctionSample();
        List<Item> list = new ArrayList<>();
        list.add(new Item("1", "name"));
        list.add(new Item("2", "name2"));
        Collection<String> prices = Collections2.transform(list, functionSample.currencyConverter);
        prices.stream().forEach(el -> System.out.println(el.toString()));
    }



}
