package Annotations.CustomAnnotation;

import java.util.ArrayList;
import java.util.List;

public class AnnotationExample {
    public static void main(String[] args) {

    }
    @Override
    @MethodInfo(author = "Slabukhin", comments = "=)", date = "30.11.16", revision = 1)
    public String toString(){
        return "Overriden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "30.11.16")
    public static void oldMethod(){
        System.out.println("Old method!");
    }

    @SuppressWarnings({"deprecation", "unchecked"})
    @MethodInfo(comments = "main method", date = "30.11.16", revision = 10)
    public static void genericTest(){
        List list = new ArrayList();
        list.add("abc");
        oldMethod();
    }

}
