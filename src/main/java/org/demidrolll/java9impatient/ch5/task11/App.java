package org.demidrolll.java9impatient.ch5.task11;

/**
 * Write a recursive factorial method in which you print all stack frames
 * before you return the value. Construct (but don’t throw) an exception
 * object of any kind and get its stack trace, as described in Section 5.1.8,
 * “Uncaught Exceptions and the Stack Trace” (page 192).
 */

public class App {
    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        method2();
    }

    public static void method2() {
        Exception ex = new Exception("test exception");
        factorial(ex.getStackTrace(), 0);
    }

    public static void factorial(StackTraceElement[] stack, int index) {
        if (stack.length > 0 && index < stack.length) {
            System.out.println(
                    stack[index].getLineNumber() + " " +
                            stack[index].getClassName() + " " +
                            stack[index].getMethodName());
            factorial(stack, ++index);
        }
    }
}
