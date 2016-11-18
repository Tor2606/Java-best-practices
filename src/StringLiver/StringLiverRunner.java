package StringLiver;

import java.lang.reflect.Field;

public class StringLiverRunner {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        /*String one = "abc";
        String two = "abc";

        System.out.println("one hash:" + showInternalCharArrayHashCode(one));
        System.out.println("two hash:" + showInternalCharArrayHashCode(two));
        System.out.println("one" + System.identityHashCode(one));
        System.out.println("two" + System.identityHashCode(two));

        String three = "abc";
        String four = new String("abc");

        System.out.println("three hash:" + showInternalCharArrayHashCode(three));
        System.out.println("two hash:" + showInternalCharArrayHashCode(four));
        System.out.println("three" + System.identityHashCode(three));
        System.out.println("four" + System.identityHashCode(four));

        one = "abd";
        two = one.intern();
        System.out.println("one hash:" + showInternalCharArrayHashCode(one));
        System.out.println("two hash:" + showInternalCharArrayHashCode(two));
        System.out.println("one" + System.identityHashCode(one));
        System.out.println("two" + System.identityHashCode(two));*/

        String one = "abc";
        String two = "abc".substring(1);
        System.out.println("one hash:" + showInternalCharArrayHashCode(one));
        System.out.println("two hash:" + showInternalCharArrayHashCode(two));
        System.out.println("one" + System.identityHashCode(one));
        System.out.println("two" + System.identityHashCode(two));
    }

    private static int showInternalCharArrayHashCode(String s) throws NoSuchFieldException, IllegalAccessException {
        final Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);
        return value.get(s).hashCode();
    }
}
