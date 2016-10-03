package ClassLoader;

import java.sql.Blob;

/**
 * Created by islabukhin on 28.09.16.
 */
public class ClassLoadersTypesSample {
    /*
        There are three types of built-in Class Loaders in Java:
        1.Bootstrap Class Loader – It loads JDK internal classes, typically loads rt.jar and other core classes for example java.lang.* package classes
        2.Extensions Class Loader – It loads classes from the JDK extensions directory, usually $JAVA_HOME/lib/ext directory.
        3.System Class Loader – It loads classes from the current classpath that can be set while invoking a program using -cp or -classpath command line options.

        It's possible to make your own classloader(example: for loading from web)
        */
    public static void main(String[] args) {
        System.out.println("class loader for HashMap: "
                + java.util.HashMap.class.getClassLoader());
        System.out.println("class loader for DNSNameService: "
                + sun.net.spi.nameservice.dns.DNSNameService.class
                .getClassLoader());
        System.out.println("class loader for this class: "
                + ClassLoadersTypesSample.class.getClassLoader());

        System.out.println(Blob.class.getClassLoader());
    }
}
