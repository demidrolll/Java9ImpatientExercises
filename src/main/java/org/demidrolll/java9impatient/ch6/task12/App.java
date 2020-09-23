package org.demidrolll.java9impatient.ch6.task12;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement the following method that stores the smallest and largest
 * element in elements in the result list:
 * public static <T> void minmax(List<T> elements,
 * Comparator<? super T> comp, List<? super T> result)
 * Note the wildcard in the last parameter—any supertype of T will do to
 * hold the result.
 */

public class App {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Number> result = new ArrayList<>();

        Arrays.minmax(list, Integer::compareTo, result);
        System.out.println(result.toString());

        list.add(1);
        Arrays.minmax(list, Integer::compareTo, result);
        System.out.println(result.toString());

        list.add(2);
        Arrays.minmax(list, Integer::compareTo, result);
        System.out.println(result.toString());
    }
}
