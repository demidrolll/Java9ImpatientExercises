package org.demidrolll.java9impatient.ch7.task14;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a method that produces an immutable list view of the numbers
 * from 0 to n, without actually storing the numbers.
 */
public class App {
    public static void main(String[] args) {
        List<Integer> list = getNumbersView(10);
        System.out.println(list);
    }

    public static List<Integer> getNumbersView(int n) {
        return Collections.unmodifiableList(
                Stream.iterate(0, i -> i < n, i -> ++i).collect(Collectors.toList())
        );
    }
}
