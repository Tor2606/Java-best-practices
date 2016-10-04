package GoogleGuava;

import GoogleGuava.Objects.Item;
import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by islabukhin on 04.10.16.
 */

// Constraints are similar to preconditions in a way that they can restrict what values
// are added to a collection. This makes collections much easier to use and code a lot cleaner,
// since constraints are separated from business code.
public class ConstraintsSample {
    private String id;
    private String name;
    private List<Item> items = Constraints.constrainedList(new ArrayList<Item>(), new Constraint<Item>() {
        @Override
        public Item checkElement(Item item) {
            Preconditions.checkNotNull(item);
            Preconditions.checkArgument(id.equals(item.getId()));
            return item;
        }
    });

    public ConstraintsSample(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        ConstraintsSample constraintsSample = new ConstraintsSample("1", "Sample1");
        Item item = new Item("1","name");//if id !="1" throws exception
        constraintsSample.items.add(item);
    }
}
