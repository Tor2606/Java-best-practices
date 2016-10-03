package AvoidConcurrentModificationExceptionUsingIterator;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by islabukhin on 23.09.16.
 */

//works with ConcurrentModificationException
//exception appears only if size was changed
public class IteratorExample {
    public static void main(String[] args) {
        List<String> simpleList = new ArrayList<String>();
        simpleList.add("1");
        simpleList.add("2");
        simpleList.add("3");
        simpleList.add("4");
        simpleList.add("5");

        /*Iterator<String> iterator = simpleList.iterator();
        while (iterator.hasNext()){
            String value = iterator.next();
            System.out.println("List Value:" + value);
            if(value.equals("3")) simpleList.remove(value);
        }*/

        Map<String, String> simpleMap = new HashMap<String, String>();
        simpleMap.put("1","1");
        simpleMap.put("2","2");
        simpleMap.put("3","3");

        Iterator<String> iterator1 = simpleMap.keySet().iterator();
        while (iterator1.hasNext()){
            String key = iterator1.next();
            System.out.println("Map value:" + simpleMap.get(key));
            if(key.equals("2")){
                simpleMap.put("1","4");
                //simpleMap.put("4","4");
            }
        }



        //-------------------------------
        //you can use ConcurrentHashMap and CopyOnWriteArrayList classes

        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();

        copyOnWriteArrayList.add("1");
        copyOnWriteArrayList.add("2");
        copyOnWriteArrayList.add("3");
        copyOnWriteArrayList.add("4");
        copyOnWriteArrayList.add("5");

        Iterator<String> it = copyOnWriteArrayList.iterator();
        while(it.hasNext()){
            String value = it.next();
            System.out.println("CopyOnWriteArrayList Value:"+value);
            if(value.equals("3")){
                copyOnWriteArrayList.remove("4");
                copyOnWriteArrayList.add("6");
                copyOnWriteArrayList.add("7");
            }
        }
        System.out.println("CopyOnWriteArrayList Size:"+copyOnWriteArrayList.size());

        Map<String,String> concurrentHashMapMap =
                new ConcurrentHashMap<String,String>();
        concurrentHashMapMap.put("1", "1");
        concurrentHashMapMap.put("2", "2");
        concurrentHashMapMap.put("3", "3");

        Iterator<String> it1 = concurrentHashMapMap.keySet().iterator();
        while(it1.hasNext()){
            String key = it1.next();
            System.out.println("HashMap Value:"+concurrentHashMapMap.get(key));
            if(key.equals("1")){
                concurrentHashMapMap.remove("3");
                concurrentHashMapMap.put("4", "4");
                concurrentHashMapMap.put("5", "5");
            }
        }

        System.out.println("HashMap Size:"+concurrentHashMapMap.size());
        //In case of CopyOnWriteArrayList, iterator doesn’t accomodate the changes in the list and works on the original list.
        //In case of ConcurrentHashMap, the behavior is not always the same.

        //If you are working on single-threaded environment and want your code to take care of the
        //extra added objects in the list then you can do so using fori code and avoiding iterator.

    }
}
