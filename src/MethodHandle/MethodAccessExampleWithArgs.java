package MethodHandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

/**
 * Created by islabukhin on 28.09.16.
 */
public class MethodAccessExampleWithArgs {
    private final int i;

    public MethodAccessExampleWithArgs(int i_) {
        this.i = i_;
    }

    private void bar(int j, String msg) {
        System.out.println("Private method is accessed with msg: " + "msg" + ", " + i + ", " + j);
    }

    //With reflection
    public static Method makeMethodReflection() {
        Method method = null;
        try {
            Class[] argTypes = new Class[]{int.class, String.class};
            method = MethodAccessExampleWithArgs.class.getDeclaredMethod("bar", argTypes);
            method.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return method;
    }


    public static MethodHandle makeMethodWithHandler() {
        MethodHandle methodHandle = null;

        MethodType methodType = MethodType.methodType(void.class, int.class, String.class);
        try {
            methodHandle = MethodHandles.lookup().findVirtual(MethodAccessExampleWithArgs.class, "bar", methodType);
            System.out.println("mh=" + methodHandle);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return methodHandle;
    }

}
