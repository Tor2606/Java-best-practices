package GoogleGuava;

import com.google.common.base.CaseFormat;

public class CaseFormatSample {
    public static void main(String[] args) {
        String someName = "Some_Name_With_Lower_Space";
        String javaName = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, someName);
        System.out.println(javaName);
        String nameWithHyphen = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, javaName);
        String nameWithSpaces = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, javaName);
        String nameWithSpacesHigh = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, javaName);
        String lowerCamel = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, javaName);
        System.out.println(nameWithSpaces);
        System.out.println(nameWithHyphen);
        System.out.println(nameWithSpacesHigh);
        System.out.println(lowerCamel);
    }
}
