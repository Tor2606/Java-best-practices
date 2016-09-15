package LambdasSamples;

import java.util.Arrays;
import java.util.List;

/**
 * Created by islabukhin on 14.09.16.
 */
public class CharacteristicsOfStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        list.stream()
                .filter(e -> e % 2 == 0)
                //.sorted()
                //.distinct()//without duplicates
                .forEach(System.out::println);
        //sized, ordered, distinct, sorted - characteristics
    }
}
