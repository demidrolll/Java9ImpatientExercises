package org.demidrolll.java9impatient.ch7.task9;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * You can update the counter in a map of counters as
 *
 * counts.merge(word, 1, Integer::sum);
 *
 * Do the same without the merge method, (a) by using contains, (b) by using
 * get and a null check, (c) by using getOrDefault, (d) by using putIfAbsent.
 */
public class App {
    public static void main(String[] args) {
        Map<String, Integer> counts;

        counts = new TreeMap<>();
        counts.put("hello", 1);
        mergeA(counts, "hello");
        mergeA(counts, "world");
        mergeA(counts, "hello");
        mergeA(counts, "my");
        System.out.println(counts);

        counts = new TreeMap<>();
        counts.put("hello", 1);
        mergeB(counts, "hello");
        mergeB(counts, "world");
        mergeB(counts, "hello");
        mergeB(counts, "my");
        System.out.println(counts);

        counts = new TreeMap<>();
        counts.put("hello", 1);
        mergeC(counts, "hello");
        mergeC(counts, "world");
        mergeC(counts, "hello");
        mergeC(counts, "my");
        System.out.println(counts);

        counts = new TreeMap<>();
        counts.put("hello", 1);
        mergeD(counts, "hello");
        mergeD(counts, "world");
        mergeD(counts, "hello");
        mergeD(counts, "my");
        System.out.println(counts);
    }

    public static void mergeA(Map<String, Integer> counts, String key) {
        if (counts.containsKey(key)) {
            counts.put(key, counts.get(key) + 1);
        } else {
            counts.put(key, 1);
        }
    }

    public static <K, V> void mergeB(Map<String, Integer> counts, String key) {
        Integer value = counts.get(key);
        if (value == null) {
            value = 0;
        }
        counts.put(key, value + 1);
    }

    public static <K, V> void mergeC(Map<String, Integer> counts, String key) {
        Integer value = counts.getOrDefault(key, 0);
        counts.put(key, value + 1);
    }

    public static <K, V> void mergeD(Map<String, Integer> counts, String key) {
        Integer value = counts.computeIfAbsent(key, k -> 0);
        counts.put(key, value + 1);
    }
}
