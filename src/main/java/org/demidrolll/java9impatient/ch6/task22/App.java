package org.demidrolll.java9impatient.ch6.task22;

import java.util.concurrent.Callable;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Improve the method public static <V, T extends Throwable> V doWork(Callable<V> c,
 * T ex) throws T of Section 6.6.7, “Exceptions and Generics” (page 225) so that
 * one doesn’t have to pass an exception object, which may never get used.
 * Instead, accept a constructor reference for the exception class
 */

public class App {

    public static void main(String[] args) {
        Callable<String> c = () -> { throw new Exception("inside call exception"); };

        try {
            doWork(c, () -> new Exception("main exception"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <V, T extends Throwable> V doWork(Callable<V> c, Supplier<T> ex) throws T {
        try {
            return c.call();
        } catch (Throwable realEx) {
            T callEx = ex.get();
            callEx.initCause(realEx);
            throw callEx;
        }
    }

}
