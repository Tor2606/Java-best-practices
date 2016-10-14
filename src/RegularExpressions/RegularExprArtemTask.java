package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExprArtemTask {
    private static final String LINK = "http://gitlab.adquality.ch/nzz-netz/kubernetes-scripts/blob/master/ws-salesforce/prod/jobs/import-sf-data-job.yaml?key1=value1&key2=value2";

    public static void main(String[] args) {
        System.out.println("1. Выбрать часть между 4 и 5 слешом: " + return4PartOfUrl(LINK));
        System.out.println("2. Оставить часть УРЛа без параметров: " + deleteParams(LINK));
        soutParamsOfUrl(LINK);
        System.out.println("4. Оставить часть УРЛа без последнего параметра:\n " + returnUrlWithoutLastParam(LINK));
        System.out.println(validateString("a1a1a1a1a1a1a1"));
    }

    public static String return4PartOfUrl(String url) {
        Pattern pattern = Pattern.compile("([\\w]+)://([\\w\\-\\.]+)/([\\w\\-\\.]+)/([\\w\\-\\.]+)/(.*)");
        Matcher matcher = pattern.matcher(url);
        matcher.matches();
        return matcher.group(4);
    }

    public static String deleteParams(String url) {
        Pattern pattern = Pattern.compile("(.+)\\?(.+)$");
        Matcher matcher = pattern.matcher(url);
        matcher.matches();
        return matcher.group(1);
    }

    public static void soutParamsOfUrl(String url) {
        Pattern pattern = Pattern.compile("((\\?)|(&))[\\w]+=[\\w]*");
        Matcher matcher = pattern.matcher(url);
        System.out.println("3. Выбрать параметры и вывести их на экран списком: ");
        while (matcher.find()) {
            System.out.println(url.substring(matcher.start() + 1, matcher.end()));
        }
    }

    public static String returnUrlWithoutLastParam(String url) {
        Pattern pattern = Pattern.compile("(.+)&(.+)$");
        Matcher matcher = pattern.matcher(url);
        matcher.matches();
        return matcher.group(1);
    }

    public static boolean validateString(String text){
        Pattern pattern = Pattern.compile("([a-z][0-9]){3,9}");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

/*    1. Выбрать часть между 4 и 5 слешом
    2. Оставить часть УРЛа без параметров
    3. Выбрать параметры и вывести их на экран списком
    4. Оставить часть УРЛа без последнего параметра*/
/*      Написать метод который будет валидировать строку по параметрам:
    1. алфавит (лат.) + цифры
    2. длина от 6 до 18 символов
    3. может начинатся только с буквы
    4. может заканчиватся только цифрой
    5. подрят цве цифры или буквы идти не могут*/
}
