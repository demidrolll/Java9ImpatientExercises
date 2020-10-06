package org.demidrolll.java9impatient.ch8.task13;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a method public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
 * that alternates elements from the streams first and second (or null if the
 * stream whose turn it is runs out of elements).
 */
public class App {
    public static void main(String[] args) {
        List<String> list = zip(
                Stream.of("a", "c", "e", "g")
                , Stream.of("b", "d")
        ).collect(Collectors.toList());

        System.out.println(list.toString());
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Stream.Builder<T> builder = Stream.builder();
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        for (int i = 0; firstIterator.hasNext() || secondIterator.hasNext(); i++) {
            T item = null;
            if (i % 2 == 0) {
                if (firstIterator.hasNext()) {
                    item = firstIterator.next();
                }
            } else {
                if (secondIterator.hasNext()) {
                    item = secondIterator.next();
                }
            }
            builder.add(item);
        }
        return builder.build();
    }
}
