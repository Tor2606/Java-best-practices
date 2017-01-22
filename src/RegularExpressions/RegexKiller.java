package RegularExpressions;

import java.util.regex.Pattern;

public class RegexKiller {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(0*)*A");
        long start = System.nanoTime();
        System.out.println(pattern.matcher("0000000000000000000000000000").matches() + ". time: " + (System.nanoTime() - start));
    }
}
