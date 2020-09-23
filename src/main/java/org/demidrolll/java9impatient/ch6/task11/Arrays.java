package org.demidrolll.java9impatient.ch6.task11;

import org.demidrolll.java9impatient.ch6.task8.Pair;

import java.util.List;

public class Arrays {
    public static <E extends Comparable<? super E>> Pair<E> minMax(List<E> list) {
        return new Pair<>(
                list.stream().min(E::compareTo).orElse(null),
                list.stream().max(E::compareTo).orElse(null)
        );
    }
}
