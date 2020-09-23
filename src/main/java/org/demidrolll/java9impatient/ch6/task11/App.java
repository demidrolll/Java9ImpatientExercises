package org.demidrolll.java9impatient.ch6.task11;

import java.util.ArrayList;
import java.util.List;

/**
 * Continue the preceding exercise and provide a method minMax that yields
 * a Pair with the minimum and maximum.
 */

public class App {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        System.out.println(Arrays.minMax(list));

        list.add(1);

        System.out.println(Arrays.minMax(list));

        list.add(2);

        System.out.println(Arrays.minMax(list));
    }
}
