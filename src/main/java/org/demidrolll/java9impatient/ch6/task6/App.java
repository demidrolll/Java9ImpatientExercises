package org.demidrolll.java9impatient.ch6.task6;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a generic method that appends all elements from one array
 * list to another. Use a wildcard for one of the type arguments. Provide
 * two equivalent solutions, one with a ? extends E wildcard and one with
 * ? super E.
 */

public class App {
    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();
        doubles.add(1.0);
        doubles.add(2.0);

        addAllExtends(doubles, numbers);
        addAllSuper(doubles, numbers);
        System.out.println(numbers.toString());
    }

    public static <E> void addAllExtends(List<? extends E> src, List<E> dst) {
        dst.addAll(src);
    }

    public static <E> void addAllSuper(List<E> src, List<? super E> dst) {
        dst.addAll(src);
    }
}
