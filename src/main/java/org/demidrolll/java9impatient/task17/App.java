package org.demidrolll.java9impatient.task17;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    private static class Wrong {
    }

    public static void main(String[] args) {
        List<String> strings = Collections.checkedList(new ArrayList(), String.class);
        ArrayList<Integer> integers = new ArrayList<>();
        Object result = new ArrayList<>(List.of(new Wrong()));
        strings = (ArrayList<String>) result;
        strings.add("a");
        strings.add("b");
        strings.add("c");
        System.out.println(strings);
    }
}
