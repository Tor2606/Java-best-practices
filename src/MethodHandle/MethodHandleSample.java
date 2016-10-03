package MethodHandle;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by islabukhin on 27.09.16.
 */
public class MethodHandleSample {

    public static void runReflection() {
        Method method = MethodAccessExampleWithArgs.makeMethodReflection();

        MethodAccessExampleWithArgs methodAccessExampleWithArgs1 = new MethodAccessExampleWithArgs(0);
        MethodAccessExampleWithArgs methodAccessExampleWithArgs2 = new MethodAccessExampleWithArgs(1);
        try {
            System.out.println("Invocation using Reflection");
            method.invoke(methodAccessExampleWithArgs1, 5, "Jabba the Hutt");
            method.invoke(methodAccessExampleWithArgs2, 7, "Boba Fett");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void runHandle() {
        MethodHandle methodHandle = MethodAccessExampleWithArgs.makeMethodWithHandler();

        MethodAccessExampleWithArgs methodAccessExampleWithArgs3 = new MethodAccessExampleWithArgs(0);
        MethodAccessExampleWithArgs methodAccessExampleWithArgs4 = new MethodAccessExampleWithArgs(1);
        try {
            System.out.println("Invocation using handler");
            methodHandle.invoke(methodAccessExampleWithArgs3, 6, "Bubba");
            methodHandle.invoke(methodAccessExampleWithArgs4, 8, "Bob");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    public static void main(String[] args) {
        runReflection();
        runHandle();
    }
}
