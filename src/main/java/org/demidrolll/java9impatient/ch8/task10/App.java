package org.demidrolll.java9impatient.ch8.task10;

import java.util.stream.Stream;

/**
 * Given a finite stream of strings, find the average string length.
 */
public class App {
    public static void main(String[] args) {
        double avg = Stream.of("Hello", "My", "World")
                .mapToInt(String::length)
                .summaryStatistics()
                .getAverage();

        System.out.println(avg);
    }
}
