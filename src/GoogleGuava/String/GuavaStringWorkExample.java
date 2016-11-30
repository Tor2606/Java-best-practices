package GoogleGuava.String;

import static com.google.common.base.Strings.*;

public class GuavaStringWorkExample {
    public static void main(String[] args) {
        System.out.println(isNullOrEmpty(null));
        System.out.println(isNullOrEmpty(""));
        System.out.println();
        System.out.println(nullToEmpty(null).equals(""));
        System.out.println(emptyToNull(""));

        System.out.println(padStart("String", 10, '_'));
        System.out.println(padEnd("String", 10, '_'));
        System.out.println(repeat("repeat_", 3));

    }
}
