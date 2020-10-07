package org.demidrolll.java9impatient.ch7.task13;

/**
 * The LinkedHashMap calls the method removeEldestEntry whenever a new element
 * is inserted. Implement a subclass Cache that limits the map to a given size
 * provided in the constructor.
 */
public class App {
    public static void main(String[] args) {
        Cache<String, Integer> cache = new Cache(2);
        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("b", 3);
        System.out.println(cache);
        cache.put("c", 4);
        System.out.println(cache);
        cache.put("d", 5);
        System.out.println(cache);
    }
}
