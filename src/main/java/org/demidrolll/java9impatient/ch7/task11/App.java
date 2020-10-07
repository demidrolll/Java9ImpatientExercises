package org.demidrolll.java9impatient.ch7.task11;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a program that reads a sentence into an array list. Then, using
 * Collections.shuffle, shuffle all but the first and last word, without copying
 * the words into another collection.
 */
public class App {

    private static class CheatRandom extends Random {

        private final int lastIndex;

        public CheatRandom(int listSize) {
            this.lastIndex = listSize - 1;
        }

        @Override
        public int nextInt(int bound) {
            if (bound == lastIndex + 1) {
                return bound - 1;
            }
            int result = super.nextInt(bound);
            if (result == 0 || result == lastIndex) {
                result = bound - 1;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String sentence = "Write a program that reads a sentence into an array list";
        List<String> words = Stream.of(sentence.split("\\PL+")).collect(Collectors.toList());

        Collections.shuffle(words, new CheatRandom(words.size()));
        System.out.println(words);

        Collections.shuffle(words, new CheatRandom(words.size()));
        System.out.println(words);

        Collections.shuffle(words, new CheatRandom(words.size()));
        System.out.println(words);
    }
}
