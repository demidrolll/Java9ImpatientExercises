package org.demidrolll.java9impatient.ch6.task8;

import java.util.regex.Pattern;

/**
 * Modify the class of the preceding exercise by adding methods max and min,
 * getting the larger or smaller of the two elements. Supply an appropriate
 * type bound for E.
 */

public class App {
    public static void main(String[] args) {
        Pair<Integer> pair = new Pair<>(20, 10);
        System.out.println(pair.min());
        System.out.println(pair.max());
    }
}
