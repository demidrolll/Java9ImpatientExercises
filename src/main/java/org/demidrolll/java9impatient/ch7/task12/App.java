package org.demidrolll.java9impatient.ch7.task12;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Using Collections.shuffle, write a program that reads a sentence, shuffles
 * the words, and prints the result. Fix the capitalization of the initial word
 * and the punctuation of the last word (before and after the shuffle). Hint:
 * Don’t shuffle the words.
 */
public class App {

    private static class CheatRandom extends Random {

        private final List<String> list;

        public CheatRandom(List<String> list) {
            this.list = list;
        }

        @Override
        public int nextInt(int bound) {
            int result = super.nextInt(bound);
            String fromValue = list.get(bound - 1);
            String toValue = list.get(result);

            if (result == 0) {
                list.set(result, toValue.toLowerCase());
                fromValue = fromValue.substring(0, 1).toUpperCase()
                        + fromValue.substring(1);
                list.set(bound - 1, fromValue);
            }

            if (bound == list.size()) {
                fromValue = fromValue.substring(0, fromValue.lastIndexOf("."));
                list.set(bound - 1, fromValue);

                if (!toValue.isEmpty()) {
                    list.set(result, toValue + ".");
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        String sentence = "Write a program 'SCHUFFLE', that reads a sentence into an array list.";
        List<String> words = Stream.of(sentence.split(" ")).collect(Collectors.toList());
        System.out.println(words);

        Collections.shuffle(words, new CheatRandom(words));
        System.out.println(words);

        Collections.shuffle(words, new CheatRandom(words));
        System.out.println(words);

        Collections.shuffle(words, new CheatRandom(words));
        System.out.println(words);

        Collections.shuffle(words, new CheatRandom(words));
        System.out.println(words);
    }
}
