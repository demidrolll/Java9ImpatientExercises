package org.demidrolll.java9impatient.ch7.task5;

import java.util.*;

public class App {
    public static void main(String[] args) {
        int n = 10;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list1.add(i);
            list2.add(i);
        }
        swap(list1, n / 2, n - 1);
        swap(list2, n / 2, n - 1);
        System.out.println(list1);
        System.out.println(list2);
    }

    public static void swap(List<?> list, int i, int j) {
        if (list instanceof RandomAccess) {
            Collections.swap(list, i, j);
        } else {
            iteratorSwap(list, i, j);
        }
    }

    private static <T> void iteratorSwap(List<T> list, int i, int j) {
        ListIterator<T> iIterator = list.listIterator(i);
        ListIterator<T> jIterator = list.listIterator(j);

        T tmp = jIterator.next();
        jIterator.set(iIterator.next());
        iIterator.set(tmp);
    }
}
