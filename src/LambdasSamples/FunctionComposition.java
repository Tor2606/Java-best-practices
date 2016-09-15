package LambdasSamples;

import java.util.Arrays;
import java.util.List;

/**
 * Created by islabukhin on 14.09.16.
 */
public class FunctionComposition {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /*//given the numbers, double the given numbers and total.
        int result = 0;
        for (int e : numbers) {
            if (e % 2 == 0) {
                result += e * 2;
            }
        }
        System.out.println(result);
*/
        //stream iterator (with function composition)
       /* System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(e -> e * 2)
                        .sum());*/


        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(e -> compute(e))
                        .sum());

        System.out.println(
                numbers.parallelStream() //faster, but need more resources
                        .filter(e -> e % 2 == 0)
                        .mapToInt(e -> compute(e))
                        .sum());




    }

    private static int compute(int number) {
        return number * 2;
    }
}
