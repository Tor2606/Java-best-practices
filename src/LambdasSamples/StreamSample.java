package LambdasSamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by islabukhin on 14.09.16.
 */
public class StreamSample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2.0)
                        .reduce(0.0, (carry, e) -> carry + e)//0.0 - basic value of carry
        );

        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToDouble(e -> e * 2.0)
                        .sum()//special reduce
        );

        //passed only "true" passed elem
        //parameter: Stream<T> filter takes Predicate<T>

        //map transforms values
        //number of input == number of input
        //parameter: Stream<T> map takes Function<T, R> to return Stream<R>
        //both stay within their swimlanes

        //reduce cuts across the swimlanes(work with another elements of stream)
        //reduce on Stream<T> takes two parameters:
        //first - type of T
        //second is type BiFunction<R,T,R> to produce a result of R

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        // double the even values and put that into list

        //wrong way
        List<Integer> doubleOfEven = new ArrayList<>();
        doubleOfEven.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .forEach(e -> doubleOfEven.add(e));
        System.out.println(doubleOfEven);
        //mutability is ok, sharing nice, shared mutability is devils work

        List<Integer> doubleOfEven2 =
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2)
                        .collect(Collectors.toList());
        //its possible to create a map(parameters are key an value) or set to
        // also it's possible to make map with collected objects with some
        // same param : collect(groupingBy(Person::getName))
        // or collect(groupingBy(Person::getName, mapping(Person::getAge, toList())))
        System.out.println(doubleOfEven2);

    }
}
