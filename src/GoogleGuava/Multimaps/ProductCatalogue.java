package GoogleGuava.Multimaps;

import GoogleGuava.Objects.Item;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;

/**
 * Created by islabukhin on 04.10.16.
 */
public class ProductCatalogue {
    private Multimap catalogue = ArrayListMultimap.create();

    public void add(Item item){
        catalogue.put(item.getClass(),item);
    }

    public <T extends Item> Collection<Item> list(Class<T> clazz) {
        return catalogue.get(clazz);
    }


}
