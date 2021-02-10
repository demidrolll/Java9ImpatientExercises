package org.demidrolll.java9impatient.ch10.task2;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * How large does an array have to be for Arrays.parallelSort to be faster than
 * Arrays.sort on your computer?
 */
public class App {

    public static void main(String[] args) {
        System.out.println("sort time plain: " + measureSort(100, Arrays::sort));
        System.out.println("sort time parallel: " + measureSort(100, Arrays::parallelSort));

        System.out.println("sort time plain: " + measureSort(1_000, Arrays::sort));
        System.out.println("sort time parallel: " + measureSort(1_000, Arrays::parallelSort));

        System.out.println("sort time plain: " + measureSort(10_000, Arrays::sort));
        System.out.println("sort time parallel: " + measureSort(10_000, Arrays::parallelSort));

        System.out.println("sort time plain: " + measureSort(100_000, Arrays::sort));
        System.out.println("sort time parallel: " + measureSort(100_000, Arrays::parallelSort));

        System.out.println("sort time plain: " + measureSort(1_000_000, Arrays::sort));
        System.out.println("sort time parallel: " + measureSort(1_000_000, Arrays::parallelSort));

        System.out.println("sort time plain: " + measureSort(9_000_000, Arrays::sort));
        System.out.println("sort time parallel: " + measureSort(9_000_000, Arrays::parallelSort));

        System.out.println("sort time plain: " + measureSort(99_000_000, Arrays::sort));
        System.out.println("sort time parallel: " + measureSort(99_000_000, Arrays::parallelSort));

        // Arrays::sort faster Arrays::parallelSort in all tests
    }

    private static long measureSort(int size, Consumer<int[]> sort) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = size - i;
        }
        long time = System.currentTimeMillis();
        sort.accept(data);
        return System.currentTimeMillis() - time;
    }
}
