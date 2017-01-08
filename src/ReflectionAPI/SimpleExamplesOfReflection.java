package ReflectionAPI;

import java.lang.reflect.Method;

public class SimpleExamplesOfReflection {
    public static void main(String[] args) {
        Foo f = new Foo();
        System.out.println(f.getClass().getName());

        Method method;
        try {
            method = f.getClass().getMethod("print", new Class<?>[0]);
            method.invoke(f);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Class<?> c = null;
        try {
            c = Class.forName("ReflectionAPI.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Foo f2 = null;

        try {
            f2 = (Foo) c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        f2.print();
    }
}

class Foo{
    public void print(){
        System.out.println("Foo print!");
    }
}
