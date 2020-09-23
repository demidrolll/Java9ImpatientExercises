package org.demidrolll.java9impatient.ch6.task16;

/**
 * public static <T extends Comparable<? super T>> void sort(List<T> list)
 *
 * public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)
 */

public class App {
    /* After erasure
    public static void sort(List<Comparable> list)

    public static Object max(Collection<Object> coll)
    */
}
