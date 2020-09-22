package org.demidrolll.java9impatient.ch6.task3;

/**
 * Implement a class Table<K, V> that manages an array list of Entry<K, V> ele-
 * ments. Supply methods to get the value associated with a key, to put a
 * value for a key, and to remove a key.
 */

public class App {
    public static void main(String[] args) {
        Table<String, Integer> table = new Table<>();
        System.out.println(table.get("name"));
        table.put("name", 1);
        table.put("name", 2);
        System.out.println(table.get("name"));
        System.out.println(table.remove("surname"));
        table.put("surname", 3);
        System.out.println(table.remove("name"));
        table.put("patronimyc", 4);
        System.out.println(table.get("surname"));
        System.out.println(table.remove("name"));
    }
}
