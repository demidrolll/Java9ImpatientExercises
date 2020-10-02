package org.demidrolll.java9impatient.ch8.task9;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.demidrolll.java9impatient.ch8.task7.App.tokens;
import static org.demidrolll.java9impatient.ch8.task6.App.isLetters;

/**
 * Read the words from /usr/share/dict/words (or a similar word list) into a
 * stream and produce an array of all words containing five distinct vowels.
 */
public class App {

    private static Set<Character> vowelsSet = Set.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) {
        try {
            String[] distinctVowels = tokens("alice.txt")
                    .filter(word -> validDistinctVowels(word, 4))
                    .distinct()
                    .toArray(String[]::new);
            System.out.println(Arrays.toString(distinctVowels));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean validDistinctVowels(String word, int count) {
        if (!isLetters(word)) {
            return false;
        }

        Map<Character, Long> vowels = word.chars()
                .mapToObj(ch -> Character.toLowerCase((char) ch))
                .filter(vowelsSet::contains)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        return vowels.size() == count
                && vowels.values().stream().allMatch(v -> v == 1);
    }
}
