package org.demidrolll.java9impatient.ch3.task8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("my");
        list.add("name");
        list.add("is");
        list.add("dmitry");
        int count = luckySort(list, String::compareTo);
        System.out.println(list);
        System.out.println("Iteration count is " + count);
    }

    private static int luckySort(ArrayList<String> strings, Comparator<String> comp) {
        int iterationCount = 1;
        while (!isIncreaseList(strings, comp)) {
            Collections.shuffle(strings);
            iterationCount++;
        }
        return iterationCount;
    }

    private static boolean isIncreaseList(ArrayList<String> strings, Comparator<String> comp) {
        for (int i = 1; i < strings.size(); i++) {
            if (comp.compare(strings.get(i), strings.get(i - 1)) < 0) {
                return false;
            }
        }
        return true;
    }
}
