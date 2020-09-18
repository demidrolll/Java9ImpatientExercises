package org.demidrolll.java9impatient.ch5.task13;

import java.util.Arrays;

/**
 * Write a method int min(int[] values) that, just before returning the smallest
 * value, asserts that it is indeed ≤ all values in the array. Use a private
 * helper method or, if you already peeked into Chapter 8, Stream.allMatch.
 * Call the method repeatedly on a large array and measure the runtime
 * with assertions enabled, disabled, and removed.
 */

public class App {

    public static void main(String[] args) {
        int[] array = new int[100000];
        Arrays.fill(array, 1);
        long time = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            min(array);
        }
        time = (System.nanoTime() - time) / 100;
        System.out.println("elapsed time " + time);

        // 750_000 ns disabled asserts
        // 760_000 ns enabled asserts
        // 750_000 ns no asserts
    }

    public static int min(int[] values) {
        int minValue = Arrays.stream(values).min().orElse(0);
        for (int value : values) {
            assert minValue <= value;
        }
        return minValue;
    }

}
