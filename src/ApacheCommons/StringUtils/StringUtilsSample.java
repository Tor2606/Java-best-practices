package ApacheCommons.StringUtils;

import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by islabukhin on 02.10.16.
 */
public class StringUtilsSample {
    public static void main(String[] args) {
        //If string is null, empty string returned. Else returns trimmed string
        System.out.println("1) Empty String >>>" +
                StringUtils.trimToEmpty("    ") + "<<<");

        //No NullPointer Exception even if null!
        System.out.println("2) Trim String. No NullPointerException >>>" +
                StringUtils.trim(null));

        //SubString
        System.out.println("3) Substring >>>" +
                StringUtils.substring("SUBSTRING", 1, 5));
        System.out.println(new String("SUBSTRING").substring(1, 5));

        //Strip whitespace from start and end of the string.(no analog in java.lang)
        //If null returns empty string
        System.out.println("4) Strip whitespace >>>" +
                StringUtils.stripToEmpty("     ABCD      "));

        //Reverse a String
        System.out.println("5) Reverse >>>" + StringUtils.reverse("REVERSE"));

        //Join all Strings in the Array into a Single String, separated by $#$
        System.out.println("6) Join Strings using separator >>>" +
                StringUtils.join(new String[]{"AB", "CD", "EF"}, "$#$"));

        //Returns index where the Strings start to differ
        System.out.println(
                "7) Index Of Difference between ABCXYZ and ABCPQR >>>" +
                        StringUtils.indexOfDifference("ABCXYZ", "ABCPQR"));

        //Compare Strings...No NullPointer Exception!
        System.out.println("8) Comapre null and null >>>" +
                StringUtils.equals(null, null));

        //Compare two strings. Case Sensitive
        System.out.println("9) Compare ABCDEFG and ABCdefg >>>" +
                StringUtils.difference("ABCDE", "ABCde"));

        //Takes Object input and returns Empty String if null.
        System.out.println("10) Return default string >>>" + "**" +
                StringUtils.defaultString(null) + "**");

        //Check if string contains only a specified set of characters. Return boolean
        System.out.println("11) Check if 643287460 contains only 0123456789 >>>" +
                StringUtils.containsOnly("643287460i", "0123456789"));

        //Check that a string does not contain any of these characters !@#$%^&*
        System.out.println("12) Check that ABCD contains none of !@#$%^&* >>>" +
                StringUtils.containsNone("ABCD", "!@#$%^&*"));

        //String can be max 12 chars including the ...(so just 9 symbols)
        System.out.println("13) Abbreviate Once upon a time >>>" +
                StringUtils.abbreviate("Once upon a time ", 12));

        //Split a String into an Array using # as seperator.
        String[] splitArr = StringUtils.split("AB#CD#EF#GH", "#");
        for (int i = 0; i < splitArr.length; i++) {
            System.out.println(i + ") " + splitArr[i]);
        }

        //is blank sample (true if not null)
        String text = "text";
        System.out.println(isBlank(text));
        text = null;
        System.out.println(isBlank(text));
    }
}
