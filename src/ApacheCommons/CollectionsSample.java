package ApacheCommons;

import org.apache.commons.collections.*;
import org.apache.commons.collections.bag.HashBag;
import org.apache.commons.collections.bidimap.TreeBidiMap;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.collections.map.LinkedMap;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by islabukhin on 03.10.16.
 */
public class CollectionsSample {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("2", 2);
        hashMap.put("1", 1);
        //Map Iteration
        IterableMap iterableMap = new HashedMap(hashMap);
        MapIterator it = iterableMap.mapIterator();
        while (it.hasNext()) {
            System.out.println(it.next() + ":" + it.getValue());
        }

        //Ordered Maps
        OrderedMap orderedMap = new LinkedMap(hashMap);
        System.out.println(orderedMap.firstKey());
        orderedMap.put("FIVE", "5");
        orderedMap.put("SIX", "6");
        orderedMap.put("SEVEN", "7");
        System.out.println(orderedMap.firstKey() + "," + orderedMap.nextKey("2"));

        /*orderedMap.firstKey();  // returns "FIVE"
        orderedMap.nextKey("FIVE");  // returns "SIX"
        orderedMap.nextKey("SIX");  // returns "SEVEN"*/

        //Bidirectional Maps
        BidiMap bidi = new TreeBidiMap();
        bidi.put("SIX", "6");
        bidi.put("FIVE", "5");
        bidi.get("SIX");  // returns "6"
        bidi.getKey("6");  // returns "SIX"
        bidi.removeValue("6");  // removes the mapping
        BidiMap inverse = bidi.inverseBidiMap();  // returns a map with keys and values swapped

        IterableMap iterableBidiMap = new HashedMap(inverse);
        MapIterator it2 = iterableBidiMap.mapIterator();
        while (it2.hasNext()) {
            System.out.println(it2.next() + ":" + it2.getValue());
        }

        //Bag. These represent collections where a certain number of copies of each element is held.
        Bag bag = new HashBag();
        bag.add("One", 4);
        bag.remove("One", 1);
        System.out.println(bag.getCount("One"));
        Iterator it3 = bag.iterator();
        while (it3.hasNext()){
            System.out.println(it3.next());
        }
    }
}
