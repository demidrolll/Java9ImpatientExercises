package org.demidrolll.java9impatient.ch8.task7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

/**
 * Turning a file into a stream of tokens, list the first 100 tokens that are
 * words in the sense of the preceding exercise. Read the file again and list
 * the 10 most frequent words, ignoring letter case.
 */

public class App {
    public static void main(String[] args) {
        try {
            firstWords();
            frequentWords();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Stream<String> tokens(String fileName) throws FileNotFoundException {
        List<String> tokens = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                tokens.add(scanner.next());
            }
        }
        return tokens.stream();
    }

    public static void firstWords() throws FileNotFoundException {
        List<String> words = tokens("alice.txt")
                .filter(org.demidrolll.java9impatient.ch8.task6.App::isLetters)
                .limit(100)
                .collect(toList());
        System.out.println(words);
    }

    public static void frequentWords() throws FileNotFoundException {
        Map<String, Long> words = tokens("alice.txt")
                .filter(org.demidrolll.java9impatient.ch8.task6.App::isLetters)
                .collect(groupingBy(String::toUpperCase, counting()));
        System.out.println(words);
    }
}
