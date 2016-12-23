package ClassLoader;

import java.net.URLClassLoader;
import java.util.Arrays;

public class ClassLoaderSample {
    public static void main(String[] args) {
        String classLoaders = Arrays.toString(((URLClassLoader) ClassLoaderSample.class.getClassLoader()).getURLs());
        System.out.println(classLoaders);
    }
}
