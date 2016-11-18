package ResourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleSample {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ResourceBundle/messages", Locale.GERMAN);
        System.out.println(resourceBundle.getString("welcome.message"));
    }
}
