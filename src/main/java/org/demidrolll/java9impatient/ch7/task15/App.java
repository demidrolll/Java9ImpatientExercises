package org.demidrolll.java9impatient.ch7.task15;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        System.out.println(getView().apply(2).size());
    }

    public static <T extends Collection<Integer>> IntFunction<T> getView() {
        return (n) -> (T) Collections.unmodifiableList(Stream.iterate(0, i -> i < n, i -> ++i).collect(Collectors.toList()));
    }
}
