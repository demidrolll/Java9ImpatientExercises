package org.demidrolll.java9impatient.ch6.task9;

import org.demidrolll.java9impatient.ch6.task8.Pair;

import java.util.List;

public class Arrays {
    public static <E extends Comparable<? super E>> Pair<E> firstLast(List<E> list) {
        if (list.size() > 1) {
            return new Pair<>(list.get(0), list.get(list.size() - 1));
        } else if (list.size() == 1) {
            return new Pair<>(list.get(0), list.get(0));
        }
        return null;
    }
}
