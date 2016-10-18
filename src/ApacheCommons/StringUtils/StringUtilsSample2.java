package ApacheCommons.StringUtils;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class StringUtilsSample2 {
    public static void main(String[] args) {
        //equals without null pointer exception
        String first = "text";
        String second = "text";
        System.out.println("Commons check: " + StringUtils.equals(first, second));
        System.out.println("Null Check: " + StringUtils.equals(null, null));

        String whiteSpace = "   ";
        System.out.println("Is blank on whitespace: " + isBlank(whiteSpace));
        System.out.println("Is empty on whitespace: "+ isEmpty(whiteSpace));

        //java.lang.String.split takes a regular expression as a separator
        String example = "one.two.three";
        String[] result = example.split(".");
        System.out.println(result.length);
        String[] commonsResult = StringUtils.split(example, ".");
        System.out.println(commonsResult.length);

        String[] numbers = {"1", "2", "3"};
        System.out.println(StringUtils.join(numbers, ":"));
    }
}
