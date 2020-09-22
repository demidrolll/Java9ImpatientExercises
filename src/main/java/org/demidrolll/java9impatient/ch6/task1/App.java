package org.demidrolll.java9impatient.ch6.task1;

/**
 * Implement a class Stack<E> that manages an array list of elements of type
 * E. Provide methods push, pop, and isEmpty.
 */

public class App {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
