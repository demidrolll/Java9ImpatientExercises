package org.demidrolll.java9impatient.ch4.task8;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class class has six methods that yield a string representation of the
 * type represented by the Class object. How do they differ when applied to
 * arrays, generic types, inner classes, and primitive types?
 */

public class App {

    private class TestInnerClass {

    }

    public static void main(String[] args) {
        System.out.println("=== String array");
        System.out.println("toString: " + String[].class.toString());
        System.out.println("getName: " + String[].class.getName());
        System.out.println("getSimpleName: " + String[].class.getSimpleName());
        System.out.println("getCanonicalName: " + String[].class.getCanonicalName());
        System.out.println("getTypeName: " + String[].class.getTypeName());
        System.out.println("toGenericString: " + String[].class.toGenericString());
        System.out.println();

        System.out.println("=== Generics");
        List<Integer> generic = new ArrayList<>();
        System.out.println("toString: " + generic.getClass().toString());
        System.out.println("getName: " + generic.getClass().getName());
        System.out.println("getSimpleName: " + generic.getClass().getSimpleName());
        System.out.println("getCanonicalName: " + generic.getClass().getCanonicalName());
        System.out.println("getTypeName: " + generic.getClass().getTypeName());
        System.out.println("toGenericString: " + generic.getClass().toGenericString());
        System.out.println();

        System.out.println("=== Inner class");
        System.out.println("toString: " + TestInnerClass.class.toString());
        System.out.println("getName: " + TestInnerClass.class.getName());
        System.out.println("getSimpleName: " + TestInnerClass.class.getSimpleName());
        System.out.println("getCanonicalName: " + TestInnerClass.class.getCanonicalName());
        System.out.println("getTypeName: " + TestInnerClass.class.getTypeName());
        System.out.println("toGenericString: " + TestInnerClass.class.toGenericString());
        System.out.println();

        System.out.println("=== int");
        System.out.println("toString: " + int.class.toString());
        System.out.println("getName: " + int.class.getName());
        System.out.println("getSimpleName: " + int.class.getSimpleName());
        System.out.println("getCanonicalName: " + int.class.getCanonicalName());
        System.out.println("getTypeName: " + int.class.getTypeName());
        System.out.println("toGenericString: " + int.class.toGenericString());
        System.out.println();
    }
}
