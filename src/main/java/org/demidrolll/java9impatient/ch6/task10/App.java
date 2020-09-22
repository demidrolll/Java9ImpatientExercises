package org.demidrolll.java9impatient.ch6.task10;

import java.util.ArrayList;
import java.util.List;

/**
 * Provide generic methods min and max in an Arrays utility class that yield the
 * smallest and largest element in an array
 */

public class App {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        System.out.println(Arrays.min(list));
        System.out.println(Arrays.max(list));

        list.add(1);

        System.out.println(Arrays.min(list));
        System.out.println(Arrays.max(list));

        list.add(2);

        System.out.println(Arrays.min(list));
        System.out.println(Arrays.max(list));
    }
}
