package org.demidrolll.java9impatient.ch6.task21;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Using the @SafeVarargs annotation, write a method that can construct arrays
 * of generic types
 *
 * List<String>[] result = Arrays.<List<String>>construct(10);
 * // Sets result to a List<String>[] of size 10
 */

public class App {

    public static void main(String[] args) {
        List<String>[] result = App.construct(10);
    }

    public static <T extends List<E>, E> T[] construct(int size) {
        return null;
    }

}
