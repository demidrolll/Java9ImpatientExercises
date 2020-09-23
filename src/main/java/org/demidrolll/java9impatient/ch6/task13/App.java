package org.demidrolll.java9impatient.ch6.task13;

/**
 * Given the method from the preceding exercise, consider this method:
 * public static <T> void maxmin(List<T> elements,
 * Comparator<? super T> comp, List<? super T> result) {
 * minmax(elements, comp, result);
 * Lists.swapHelper(result, 0, 1);
 * }
 * Why would this method not compile without wildcard capture? Hint: Try
 * to supply an explicit type Lists.<___>swapHelper(result, 0, 1).
 */

public class App {
    public static void main(String[] args) {
    }
}
