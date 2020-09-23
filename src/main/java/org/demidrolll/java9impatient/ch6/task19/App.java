package org.demidrolll.java9impatient.ch6.task19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Consider the method
 *
 * public static <T> ArrayList<T> repeat(int n, T obj)
 *
 * in Section 6.6.3, “You Cannot Instantiate Type Variables” (page 221). This
 * method had no trouble constructing an ArrayList<T> which contains an array
 * of T values. Can you produce a T[] array from that array list without using
 * a Class value or a constructor reference? If not, why not?
 */

public class App {

    public static void main(String[] args) {
        ArrayList<String> list = repeat(10, "a");
        System.out.println("list = " + list);
        String[] strings = repeatArray(list);
        System.out.println(Arrays.toString(strings));
    }

    public static <T> ArrayList<T> repeat(int n, T obj) {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) result.add(obj);
        return result;
    }

    public static <T> T[] repeatArray(ArrayList<T> list) {
        return null; //(T[]) list.toArray(); // exception: java.lang.Object cannot be cast to java.lang.String
    }

}
