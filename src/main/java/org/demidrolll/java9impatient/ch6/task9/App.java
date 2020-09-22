package org.demidrolll.java9impatient.ch6.task9;

import java.util.ArrayList;
import java.util.List;

/**
 * In a utility class Arrays, supply a method
 * public static <E> Pair<E> firstLast(ArrayList<___> a)
 * that returns a pair consisting of the first and last element of a. Supply an
 * appropriate type argument.
 */

public class App {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(Arrays.firstLast(list));
        list.add(1);
        System.out.println(Arrays.firstLast(list));
        list.add(2);
        System.out.println(Arrays.firstLast(list));
        list.add(3);
        System.out.println(Arrays.firstLast(list));
    }
}
