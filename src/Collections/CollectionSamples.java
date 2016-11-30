package Collections;

import java.util.*;

public class CollectionSamples {
    public static void main(String[] args) {
        //Good performance
        //key in map and item in set would be better immutable
        //iteration order is undefined
        HashMap<String, Long> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();

        //sorted
        //slow
        //ascending(восход) order of iteration
        //elements must be comparable, or comparator must be set
        TreeMap<String, Long> treeMap = new TreeMap<>(); // new FastTreeMap() analog in apache
        TreeSet<String> treeSet = new TreeSet<>();

        //fast adding to beginning
        //fast iteration through
        //iteration equals insertion order
        LinkedList<String> linkedList = new LinkedList<>();

        //iteration equals insertion order of keys, or access order
        //re-insertion of an item does not affect insertion order
        LinkedHashMap<String, Long> longLinkedHashMap = new LinkedHashMap<>();
        // re-insertion of an item does not affect insertion order
        //iteration equals insertion order
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        //iteration equals insertion order
        ArrayList<String> arrayList = new ArrayList<>();
    }
}
