package org.demidrolll.java9impatient.ch6.task2;

public class App {
    public static void main(String[] args) {
        testObjectStack();
        testGenericStack();
    }

    public static void testObjectStack() {
        ObjectStack<String> stack = new ObjectStack<>(1);
        System.out.println(stack.isEmpty());
        stack.push("1");
        stack.push("2");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }

    public static void testGenericStack() {
        GenericStack<String> stack = new GenericStack<>(1);
        System.out.println(stack.isEmpty());
        stack.push("1");
        stack.push("2");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
