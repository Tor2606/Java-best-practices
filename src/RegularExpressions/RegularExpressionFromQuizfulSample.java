package RegularExpressions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.google.common.collect.Lists.newArrayList;

public class RegularExpressionFromQuizfulSample {
    private static List<String> patternList = newArrayList();

    public static void main(String[] args) {
        patternList.add("[a-z0-9_-]+\\.(com|ua|ru)");//metaSymbols

        System.out.println(matchesTest("1_s.com",0));
        System.out.println(matchesTest("_#bla.com",0));

        String text = "Колобок, колабок, Колабок";
        String text2 = text.replaceAll("[^к]ол[оа]бок", "ball");//[] - symbol class, not metaSymbol from regex
        System.out.println(text2);//[^symbol] - not this "symbol"

        String group1 = "(якороль).+(\\1)";
        String group2 = "(э).+[\\d]";
        String group3 = "(якороль){2}$.+(якороль)";
        Pattern p = Pattern.compile(group3);
        Matcher m = p.matcher("регулярные выражения это круто 1 регулярные" +
                " выражения это круто регулярные выражения это круто якороль Я СЕГОДНЯ ЕЛ БАНАНЫ якороль " +
                "регулярные выражения якороль это круто" );
        if(m.find()){
            System.out.println(m.group());
        }
    }

    public static boolean matchesTest(String testText, int numberOfPattern){
        Pattern p = Pattern.compile(patternList.get(numberOfPattern));
        Matcher m = p.matcher(testText);
        return m.matches();
    }

}
