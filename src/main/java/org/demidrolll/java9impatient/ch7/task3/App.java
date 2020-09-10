package org.demidrolll.java9impatient.ch7.task3;

import java.util.HashSet;
import java.util.Set;

/**
 * How do you compute the union, intersection, and difference of two sets,
 * using just the methods of the Set interface and without using loops?
 */

public class App {
    public static void main(String[] args) {
        Set<Integer> setOne = new HashSet<>();
        setOne.add(1);
        setOne.add(2);
        setOne.add(3);

        Set<Integer> setTwo = new HashSet<>();
        setTwo.add(3);
        setTwo.add(4);
        setTwo.add(1);

        // union
        Set<Integer> union = new HashSet<>(setOne);
        union.addAll(setTwo);
        System.out.println(union.toString());

        // intersection
        Set<Integer> intersection = new HashSet<>(setOne);
        intersection.retainAll(setTwo);
        System.out.println(intersection.toString());

        // difference
        Set<Integer> difference = new HashSet<>(setOne);
        difference.removeAll(setTwo);
        System.out.println(difference.toString());
    }
}
