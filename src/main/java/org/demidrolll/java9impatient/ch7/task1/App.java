package org.demidrolll.java9impatient.ch7.task1;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Implement the “Sieve of Erathostenes” algorithm to determine all prime
 * numbers ≤ n. Add all numbers from 2 to n to a set. Then repeatedly find
 * the smallest element s in the set, and remove s2, s · (s + 1), s · (s + 2),
 * and so on. You are done when s2 > n. Do this with both a HashSet<Integer>
 * and a BitSet
 */

public class App {

    public static void main(String[] args) {
        viaHashSet();
        viaBitSet();
    }

    public static void viaHashSet() {
        int n = 100;
        Set<Integer> numbers = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            numbers.add(i);
        }
        int s = 2;
        int index;
        int step;
        while (s * s <= n) {
            step = 0;
            do {
                index = s * (s + step);
                step++;
                numbers.remove(index);
            } while (index <= n);
            s++;
        }
        System.out.println(numbers.toString());
    }

    public static void viaBitSet() {
        int n = 100;
        BitSet numbers = new BitSet();
        numbers.set(0, 1, false);
        numbers.set(2, n + 1, true);

        int s = 2;
        int index;
        int step;
        while (s * s <= n) {
            step = 0;
            do {
                index = s * (s + step);
                step++;
                numbers.set(index, false);
            } while (index <= n);
            s++;
        }

        System.out.println(numbers.toString());
    }
}
