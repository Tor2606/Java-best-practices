package GoogleGuava;

import com.google.common.base.CharMatcher;

public class CharMatcherSample {
    public static void main(String[] args) {
        String input1 = "Some text with date of 26/12/16/16:00";
        CharMatcher charMatcher1 = CharMatcher.DIGIT.or(CharMatcher.is(':')).or(CharMatcher.is('/'));
        String output1 = charMatcher1.retainFrom(input1);
        System.out.println(output1);

        String input2 = "DO NOT scream at me";
        CharMatcher charMatcher2 = CharMatcher.JAVA_UPPER_CASE.or(CharMatcher.BREAKING_WHITESPACE).negate();
        String output2 = charMatcher2.removeFrom(input2);
        System.out.println(output2);

        String input3 = "DO NOT scream at me";
        CharMatcher charMatcher3 = CharMatcher.inRange('m', 's').or(CharMatcher.is('a')).or(CharMatcher.BREAKING_WHITESPACE);
        String output3 = charMatcher3.retainFrom(input3);
        System.out.println(output3);
    }


}
