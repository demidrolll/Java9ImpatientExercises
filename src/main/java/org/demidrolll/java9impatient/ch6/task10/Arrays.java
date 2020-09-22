package org.demidrolll.java9impatient.ch6.task10;

import java.util.List;

public class Arrays {
    public static <E extends Comparable<? super E>> E min(List<E> list) {
        return list.stream().min(E::compareTo).orElse(null);
    }

    public static <E extends Comparable<? super E>> E max(List<E> list) {
        return list.stream().max(E::compareTo).orElse(null);
    }
}
