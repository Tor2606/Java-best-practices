package FormatterSample;

import java.util.Calendar;
import java.util.Formatter;

public class FormatterSample {
    public static void main(String... args) {
        int num = 15;
        double dNum = 15.3;
        String text = "string";
        Formatter formatter = new Formatter();
        formatter.format("Text %h , %d, %o ; %f, %tM  %ta", num, num, num, dNum, Calendar.getInstance(), Calendar.getInstance());
        System.out.println(formatter);
    }


}
