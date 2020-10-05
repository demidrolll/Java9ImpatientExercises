package org.demidrolll.java9impatient.ch8.task11;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a finite stream of strings, find all strings of maximum length.
 */
public class App {
    public static void main(String[] args) {
        String[] source = new String[] {"Hello", "My", "World"};
        int maxLength = Stream.of(source)
                .mapToInt(String::length)
                .max()
                .orElse(0);
        List<String> list = Stream.of(source).filter(s -> s.length() == maxLength).collect(Collectors.toList());

        System.out.println(list);
    }
}
