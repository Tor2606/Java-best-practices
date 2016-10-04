package GoogleGuava.PredicateAndFunctions;

import GoogleGuava.Objects.Item;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by islabukhin on 04.10.16.
 */
// Predicates evaluate if something is true or false but can also be combined into more
// complex evaluations using “and”, “or”, “not” and “in”.What normally would require a
// for-loop and bunch of if statements can now be reduced to a one-liner. How sweet is that?
public class PredicateSample {
    Predicate<Item> longNamePolicy = new Predicate<Item>() {
        @Override
        public boolean apply(Item item) {
            if(item.getName().length() > 6){
                return true;
            }
            return false;
        }
    };

    public static void main(String[] args) {
        PredicateSample predicateSample = new PredicateSample();
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("1", "name"));
        itemList.add(new Item("2", "longName"));
        itemList.add(new Item("3", "veryLongName"));
        Collection<Item> longNameItems = Collections2.filter(itemList, predicateSample.longNamePolicy);
        longNameItems.stream().forEach(el -> System.out.println(el.toString()));
    }
}
