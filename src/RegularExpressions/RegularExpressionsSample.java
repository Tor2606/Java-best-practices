package RegularExpressions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.google.common.collect.Lists.newArrayList;

public class RegularExpressionsSample {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[A-Z]+");
        String text = "SOMETEXT IS written HERE";
        Matcher matcher = pattern.matcher(text);

        //System.out.println(matcher.matches());// if pattern matches entire
        //System.out.println(matcher.lookingAt());// beginning
        System.out.println(matcher.find());
        while (matcher.find()){
            System.out.println(text.substring(matcher.start(),matcher.end()));
        }

        Pattern anotherpattern = Pattern.compile("[a-z]+");
        String text2 = "Some New TEXT here";
        Matcher matcher2 = anotherpattern.matcher(text2);
        System.out.println(matcher2.replaceFirst("REPLACED"));
        System.out.println(matcher2.replaceAll("ALL"));
        matcher2.reset();
        System.out.println(matcher2.replaceAll("NEW_ALL"));
        matcher2.reset("new Text here");
        System.out.println(matcher2.replaceFirst("Last"));

        System.out.println("--------------");

        String lastString = "Texting Text 4144 test for mat4ing?!?";
        List<String> patterns = newArrayList();
        patterns.add("^Text");//0 beginning of line
        patterns.add("$?!?");
        patterns.add("..x.i");
        patterns.add("[^…abT]");//matches to all chars except ab
        patterns.add("[…a]");
        patterns.add("\\AText");//5 beginning og entire str
        patterns.add("\\z ?!?");
        patterns.add("\\Z ?!?");
        patterns.add("[Te]*");//Matches 0 or more occurrences of preceding expression.
        patterns.add("[Te]+");
        patterns.add("[a-z]?");//10
        patterns.add("[Tex,or]{3}");//num of literals to compare from pattern
        patterns.add("[Text]{2,}");
        patterns.add("[Text]{2,3}");
        patterns.add("xt|Te");//or
        patterns.add("(Text| for)|([0-9]+)");//15
        patterns.add("(?:Tex)");
        patterns.add("\\w [a-z]");
        patterns.add("\\W");
        patterns.add("\\s.");
        patterns.add("\\S");//20
        patterns.add("\\d");
        patterns.add("\\ATe|\\G(x)");


        Pattern lastPattern = Pattern.compile(patterns.get(22));
        Matcher lastMatcher = lastPattern.matcher(lastString);
        System.out.println(lastMatcher.find());

        lastMatcher.reset();
        while(lastMatcher.find()){
            System.out.println(lastString.substring(lastMatcher.start(),lastMatcher.end()));
        }
    }


}