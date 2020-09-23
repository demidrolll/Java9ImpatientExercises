package org.demidrolll.java9impatient.ch6.task20;

import java.util.Arrays;
import java.util.Collections;

/**
 * Implement the method
 * SafeVarargs public static final <T> T[] repeat(int n, T... objs)
 * Return an array with n copies of the given objects. Note that no Class
 * value or constructor reference is required since you can reflectively
 * increase objs.
 */

public class App {
    public static void main(String[] args) {
        String[] strings = repeat(3, "a", "b", "c");
        System.out.println(Arrays.toString(strings));
    }

    @SafeVarargs
    public static <T> T[] repeat(int n, T... objs) {
        T[] result = Arrays.copyOf(objs, n * objs.length);
        for (int i = 1; i < n; i++) {
            System.arraycopy(objs, 0, result, objs.length * i, objs.length);
        }
        return result;
    }
}
