package org.demidrolll.java9impatient.ch7.task6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * I encouraged you to use interfaces instead of concrete data structures—for
 * example, a Map instead of a TreeMap. Unfortunately, that advice goes only
 * so far. Suppose you have a method parameter of type Map<String,
 * Set<Integer>>, and someone calls your method with a HashMap<String,
 * HashSet<Integer>>. What happens? What parameter type can you use instead?
 */
public class App {
    public static void main(String[] args) {
        HashMap<String, HashSet<Integer>> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        map.put("hello", set);
        Integer value = view(map, "hello");
    }

    // some example of use
    @SuppressWarnings("unchecked")
    public static <T extends Map<K, V>, K, V extends Set<E>, E> E view(T map, K key) {
        V value = map.get(key);
        System.out.println(value);
        return (E) value.toArray()[0];
    }
}
