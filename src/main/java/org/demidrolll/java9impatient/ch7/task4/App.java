package org.demidrolll.java9impatient.ch7.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class App {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");
        ListIterator<String> iterator1 = words.listIterator();
        ListIterator<String> iterator2 = words.listIterator();
        iterator1.add("!");
        iterator2.next();
    }
}
