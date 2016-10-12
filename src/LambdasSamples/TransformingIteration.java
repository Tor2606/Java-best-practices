package LambdasSamples;

import java.util.Arrays;
import java.util.List;

/**
 * Created by islabukhin on 14.09.16.
 */
public class TransformingIteration {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //external iterators
        /*for (int i = 0; i < numbers.size(); i++) {
            System.out.println("fori:" + numbers.get(i));
        }

        //external iterator also
        for (int elem: numbers
             ) {
            System.out.println("foreach:" + elem);
        }

        //internal iteration
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("anonymous" + integer);
            }
        });*/

        //internal iteration
        //numbers.forEach((Integer integer)-> System.out.println("lambda" + integer));

        //with type inference (in java8)
        //numbers.forEach((integer)-> System.out.println("lambda" + integer));

        //parenthesis is optional, but only for one parameter lambdas
        /*numbers.forEach(integer -> System.out.println("lambda" + integer));

        //if you just pass the object from collection, without doing something with it
        numbers.forEach(System.out::println);

        //passing to static method
        numbers.stream().map(String::valueOf).forEach((integer)-> System.out.println("lambda" + integer));

        //when element is target
        numbers.stream().map(e -> e.toString()).forEach((integer)-> System.out.println("lambda" + integer));
*/


        //two parameters
        System.out.println(
                //numbers.stream().reduce(0, (total, e) -> Integer.sum(e, total))
                numbers.stream().reduce(0, Integer::sum)
        );
    }
}
