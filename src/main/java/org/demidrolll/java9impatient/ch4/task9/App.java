package org.demidrolll.java9impatient.ch4.task9;

import java.lang.reflect.Field;

/**
 * Write a “universal” toString method that uses reflection to yield a string
 * with all instance variables of an object. Extra credit if you can handle
 * cyclic references
 */

public class App {

    public static void main(String[] args) {
        System.out.println(toString(new TestChildClass()));
    }

    public static String toString(Object object) {
        StringBuilder builder = new StringBuilder();
        Class<?> cl = object.getClass();
        while (cl != null) {
            Field[] fields = cl.getDeclaredFields();
            for (Field field : fields) {
                builder.append(field.getType().getSimpleName());
                builder.append(" ");
                builder.append(field.getName());
                builder.append("\n");
            }
            cl = cl.getSuperclass();
        }
        return builder.toString();
    }
}
