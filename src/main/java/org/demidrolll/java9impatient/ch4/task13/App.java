package org.demidrolll.java9impatient.ch4.task13;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.DoubleFunction;

public class App {
    public static void main(String[] args) {
        try {
            printTableReflection(Math.class.getMethod("sqrt", double.class), 0 , 10, 1);
            printTableReflection(Double.class.getMethod("toHexString", double.class), 0 , 10, 1);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        printTableFunctional(Math::sqrt, 1, 10, 1);
        printTableFunctional(Double::toHexString, 1, 10, 1);
    }

    private static void printTableReflection(Method method, int lower, int upper, int step) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Reflection");
        for (double i = lower; i <= upper; i += step) {
            System.out.println("(" + i + ") = " + method.invoke(null, i));
        }
        System.out.println();
    }

    private static void printTableFunctional(DoubleFunction<Object> func, int lower, int upper, int step) {
        System.out.println("Functional");
        for (double i = lower; i <= upper; i += step) {
            System.out.println("(" + i + ") = " + func.apply(i));
        }
        System.out.println();
    }
}
