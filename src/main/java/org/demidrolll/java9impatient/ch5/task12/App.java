package org.demidrolll.java9impatient.ch5.task12;

import java.util.Objects;

public class App {
    public static void main(String[] args) {

        String s = args.length > 0 ? args[0] : null;

        withNonNull("a");
        withAssert("b");

        //withNonNull(null);
        withAssert(s);

        System.out.println("end");
    }

    public static void withNonNull(String s) {
        s = Objects.requireNonNull(s);
        System.out.println("after non null " + s);
    }

    public static void withAssert(String s) {
        assert s != null : "s is null";
        System.out.println("after assert");
    }
}
