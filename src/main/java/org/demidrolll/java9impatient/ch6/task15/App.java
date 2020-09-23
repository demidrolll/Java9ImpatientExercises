package org.demidrolll.java9impatient.ch6.task15;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * Implement a method map that receives an array list and a Function<T, R>
 * object (see Chapter 3), and that returns an array list consisting of the
 * results of applying the function to the given elements.
 */

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        ArrayList<String> strings = map(integers, i -> "String " + i.toString());
        System.out.println(strings);
    }

    public static <T, R> ArrayList<R> map(ArrayList<T> list, Function<T, R> func) {
        ArrayList<R> mapList = new ArrayList<>();
        for (T item : list) {
            mapList.add(func.apply(item));
        }
        return mapList;
    }
}
