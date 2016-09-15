package LambdasSamples;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by islabukhin on 14.09.16.
 */
public class InfiniteStream {
    public static void main(String[] args) {
        System.out.println(Stream.iterate(100, e -> e + 1));
        //start with 100, create the series
        //100,101,102,103,...

        //Given a number k, and a count n, find the double of n
        //even numbers starting with k, where sqrt of each number is > 20

        int k = 121;
        int n = 51;
        System.out.println(compute(k, n));

        List<Integer> list = Stream.iterate(3, e -> e + 1)
                .limit(10)
                .collect(Collectors.toList());
        list.stream().forEach(System.out::println);

    }

    private static int compute(int k, int n) {
        int result = 0;

        /*int index = k;
        int count = 0;
        while (count < n) {
            if (index % 2 == 0 && Math.sqrt(index) > 20) {
                result += index * 2;
                count++;
            }
            index++;
        }
        return result;*/
        return Stream.iterate(k, e -> e + 1)  //unbounded, lazy
                .filter(e -> e % 2 == 0)        //unbounded, lazy
                .filter(e -> Math.sqrt(e) > 20)     //unbounded, lazy
                .mapToInt(e -> e * 2)       //unbounded, lazy
                .limit(n)       //sized, lazy
                .sum();
    }
}
