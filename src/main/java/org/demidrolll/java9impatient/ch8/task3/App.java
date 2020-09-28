package org.demidrolll.java9impatient.ch8.task3;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Suppose you have an array int[] values = { 1, 4, 9, 16 }. What is
 * Stream.of(values)? How do you get a stream of int instead?
 */

public class App {
    public static void main(String[] args) {
        int values[] = {1, 4, 9, 16};
        Stream<int[]> arrayValues = Stream.of(values);
        IntStream intValues = Arrays.stream(values);
    }
}
