package LambdasSamples;

import java.util.Arrays;
import java.util.List;

/**
 * Created by islabukhin on 14.09.16.
 */
public class Performance {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        //given an ordered list find the double of the first even number greater than 3

        int result = 0;
        for (int e : numbers) {
            if (e > 3 && e % 2 == 0) {
                result = e * 2;
                break;
            }
        }
        System.out.println(result);

        //the same performance
        System.out.println(
                numbers.stream()
                        .filter(Performance::isGT3)
                        .filter(Performance::isEven)
                        .map(Performance::doubleIt)
                        .findFirst()
        );
    }

    private static int doubleIt(int integer) {
        System.out.println("double it " + integer);
        return integer*2;
    }

    private static boolean isEven(int integer) {
        System.out.println("Is even " + integer);
        return integer % 2 == 0;
    }

    private static boolean isGT3(int integer) {
        System.out.println("isGT3 " + integer);
        return integer > 3;
    }
}
