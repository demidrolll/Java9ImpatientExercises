package org.demidrolll.java9impatient.ch4.task12;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        long reflectionTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            reflectionHelloWorld();
        }
        reflectionTime = System.nanoTime() - reflectionTime;
        System.out.println("reflection call: " + reflectionTime);

        long directTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            reflectionHelloWorld();
        }
        directTime = System.nanoTime() - directTime;
        System.out.println("direct call: " + directTime);

        System.out.println("diff: " + ((double) reflectionTime / directTime));
    }

    private static void reflectionHelloWorld() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Field outField = System.class.getField("out");
        Method printMethod = outField.getType().getMethod("println", String.class);
        printMethod.invoke(outField.get(null), "Hello, World");
    }
}
