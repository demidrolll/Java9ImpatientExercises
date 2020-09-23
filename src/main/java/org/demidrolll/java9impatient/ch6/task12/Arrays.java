package org.demidrolll.java9impatient.ch6.task12;

import java.util.Comparator;
import java.util.List;

public class Arrays {
    public static <T> void minmax(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        T min = elements.stream().min(comp).orElse(null);
        result.add(min);
        T max = elements.stream().max(comp).orElse(null);
        result.add(max);
    }
}
