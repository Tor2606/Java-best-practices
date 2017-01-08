package StringLiver;

import java.util.Arrays;

import static com.google.common.collect.Lists.newArrayList;

public class StringMethods {
    public static void main(String[] args) {
        String text = " name, some   ";
        System.out.println(text);
        System.out.println(text.length());
        System.out.println(text.charAt(2));
        System.out.println(text.codePointAt(2));
        System.out.println(text.codePointBefore(3));
        System.out.println(text.codePointCount(0,4));

        System.out.println(text.compareTo(" ne"));
        System.out.println(text.compareToIgnoreCase(" NE"));
        System.out.println(text.contains("name"));
        System.out.println(text.contentEquals(" name"));
        System.out.println(text.indexOf("na"));
        System.out.println(text.endsWith("e   "));
        System.out.println(text.startsWith(" na"));
        System.out.println(text.isEmpty());
        System.out.println(Arrays.toString(text.getBytes()));
        System.out.println(text.lastIndexOf('m'));
        System.out.println(text.matches("[a-z,\\s].+"));
        System.out.println(text.intern().replace('m', 'n'));
        System.out.println(text);
        newArrayList(text.split(",")).forEach(System.out::println);
        System.out.println(text.offsetByCodePoints(1,2));
        System.out.println(text.toUpperCase());
        System.out.println(text.toLowerCase());
        System.out.println(text.trim());
        System.out.println(text.substring(1,4));

        System.out.println("----------String------------");
        System.out.println(String.valueOf(1));
        System.out.println(String.join(":", newArrayList("num1", "num2", "num3")));
        System.out.println(String.copyValueOf(new char[]{'a','s'}));
        System.out.println(String.format("some value %d", 2));
    }
}
