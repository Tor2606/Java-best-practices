package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaseInsensitiveSample {
    public static void main(String[] args) {
        String text = "SoMe";
        Pattern pattern = Pattern.compile("(?i)(some)");
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.matches());
    }
}
