package org.demidrolll.java9impatient.ch6.task13;

import org.demidrolll.java9impatient.ch6.task12.Arrays;

import java.util.Comparator;
import java.util.List;

public class Lists {
    public static boolean hasNulls(List<?> elements) {
        for (Object e : elements) {
            if (e == null) return true;
        }
        return false;
    }

    public static void swap(List<?> elements, int i, int j) {
        swapHelper(elements, i, j);
    }
    
    private static <T> void swapHelper(List<T> elements, int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

    public static <T> void maxmin(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        Arrays.minmax(elements, comp, result);
        Lists.swapHelper(result, 0, 1);
    }
}