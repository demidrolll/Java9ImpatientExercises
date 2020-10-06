package org.demidrolll.java9impatient.ch7.task8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a program that reads all words in a file and prints out on which
 * line(s) each of them occurred. Use a map from strings to sets.
 */
public class App {
    public static void main(String[] args) {
        List<String> lines = Collections.emptyList();
        try (Stream<String> linesStream = Files.lines(Paths.get("alice.txt"))) {
            lines = linesStream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Set<Integer>> map = new TreeMap<>();
        Integer lineNumber = 0;
        for (String line : lines) {
            lineNumber++;
            String[] words = line.toLowerCase().split("\\PL+");
            for (String word : words) {
                if (!word.trim().isEmpty()) {
                    Set<Integer> value = map.computeIfAbsent(word, k -> new TreeSet<>());
                    value.add(lineNumber);
                }
            }
        }
        System.out.println(map);
    }
}
