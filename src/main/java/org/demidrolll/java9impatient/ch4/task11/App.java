package org.demidrolll.java9impatient.ch4.task11;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field outField = java.lang.System.class.getField("out");
        Method printMethod = outField.getType().getMethod("println", String.class);
        printMethod.invoke(outField.get(null), "Hello, World");
    }
}
