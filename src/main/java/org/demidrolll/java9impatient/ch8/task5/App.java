package org.demidrolll.java9impatient.ch8.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * The codePoints method in Section 8.3, “The filter, map, and flatMap Methods”
 * (page 263) was a bit clumsy, first filling an array list and then turning
 * it into a stream. Write a stream-based version instead, using the
 * IntStream.iterate method to construct a finite stream of offsets, then extract
 * the substrings.
 */

public class App {

    public static void main(String[] args) {
        String source = "Hello \uD800\uDC00 World \uD835\uDD46!";
        System.out.println(Arrays.toString(originalCodePoints(source).toArray()));
        System.out.println(Arrays.toString(streamCodePoints(source).toArray()));
    }

    public static Stream<String> streamCodePoints(String s) {
        return Stream
                .iterate(
                        new int[] {0, s.offsetByCodePoints(0, 1)},
                        // stop iterate Java 9: i[i] < s.length()
                        i -> new int[] {i[1], s.offsetByCodePoints(i[1], 1)})
                .map(i -> s.substring(i[0], i[1]))
                // stop iterate Java 8
                .limit(s.codePointCount(0, s.length()));
    }

    public static Stream<String> originalCodePoints(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = s.offsetByCodePoints(i, 1);
            result.add(s.substring(i, j));
            i = j;
        }
        return result.stream();
    }

}
