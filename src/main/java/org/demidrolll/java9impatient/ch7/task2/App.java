package org.demidrolll.java9impatient.ch7.task2;

import java.util.*;

/**
 * In an array list of strings, make each string uppercase. Do this with (a)
 * an iterator, (b) a loop over the index values, and (c) the replaceAll method.
 */

public class App {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("my");
        words.add("world");
        viaIterator(new ArrayList<>(words));
        viaIndex(new ArrayList<>(words));
        viaReplace(new ArrayList<>(words));
    }

    public static void viaIterator(List<String> words) {
        ListIterator<String> iterator = words.listIterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            iterator.set(word.toUpperCase());
        }
        System.out.println(words.toString());
    }

    public static void viaIndex(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            words.set(i, words.get(i).toUpperCase());
        }
        System.out.println(words.toString());
    }

    public static void viaReplace(List<String> words) {
        words.replaceAll(word -> word.toUpperCase());
        System.out.println(words.toString());
    }
}
