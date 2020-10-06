package org.demidrolll.java9impatient.ch7.task7;

import com.sun.source.tree.Tree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a program that reads all words in a file and prints out how often
 * each word occurred. Use a TreeMap<String, Integer>.
 */
public class App {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("alice.txt"))) {
            List<String> words = lines
                    .flatMap(s -> Stream.of(s.toLowerCase().split("\\PL+")))
                    .collect(Collectors.toList());
            Map<String, Integer> map = new TreeMap<>();
            for (String word : words) {
                map.merge(word, 1, Integer::sum);
            }
            System.out.println(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
