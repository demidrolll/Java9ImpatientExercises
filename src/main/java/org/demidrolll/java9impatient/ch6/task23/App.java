package org.demidrolll.java9impatient.ch6.task23;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * In the cautionary note at the end of Section 6.6.7, “Exceptions and
 * Generics” (page 225), the throwAs helper method is used to “cast” ex into a
 * RuntimeException and rethrow it. Why can’t you use a regular cast, i.e. throw
 * (RuntimeException) ex?
 */

public class App {
    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void throwAs(Throwable e) throws T {
        throw (T) e; // The cast is erased to (Throwable) e
    }

    public static <V> V doWork(Callable<V> c) {
        try {
            return c.call();
        } catch (Throwable ex) {
            App.throwAs(ex);
            return null;
        }
    }

    public static List<String> readAll(Path path) {
        return doWork(() -> Files.readAllLines(path));
    }

    public static void main(String[] args) {
        List<String> result = readAll(Paths.get("test.txt"));
        System.out.println(result);
    }
}
