package ProjectsCoins;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectCoins {
    public static void main(String[] args) {
        int num1 = 100000;
        int num2 = 100_000;
        System.out.println(num1 + ";" + num2);

        List<Map<String, String>> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "one");
        list.add(map);
        System.out.println(list);

        try {
            Class string = Class.forName("java.lang.String");
            string.getMethod("length").invoke("some text");
        } catch (ClassNotFoundException | NoSuchMethodException
                | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
