package org.demidrolll.java9impatient.ch6.task4;

/**
 * In the previous exercise, make Entry into a nested class. Should that class
 * be generic?
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
        System.out.println(table.get("patronimyc"));
    }
}
