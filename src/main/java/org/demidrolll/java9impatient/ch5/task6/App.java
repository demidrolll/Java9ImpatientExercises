package org.demidrolll.java9impatient.ch5.task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Section 5.1.6, “The finally Clause” (page 189) has an example of a broken
 * try statement with catch and finally clauses. Fix the code with (a) catching
 * the exception in the finally clause, (b) a try/catch statement containing a
 * try/finally statement, and (c) a try-with-resources statement with a catch
 * clause.
 */

public class App {
    public static void main(String[] args) {
    }

    public static void a() throws IOException {
        BufferedReader in = null;
        Throwable mainEx = null;
        try {
            in = Files.newBufferedReader(Paths.get(""), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            mainEx = ex;
            throw ex;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Throwable ex) {
                    if (mainEx != null) {
                        mainEx.addSuppressed(ex);
                    }
                }
            }
        }
    }

    public static void b() {
        BufferedReader in = null;
        Throwable addEx = null;
        try {
            try {
                in = Files.newBufferedReader(Paths.get("abc"), StandardCharsets.UTF_8);
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (Throwable ex) {
                    addEx = ex;
                }
            }
        } catch (Throwable ex) {
            if (addEx != null) {
                ex.addSuppressed(addEx);
            }
            ex.printStackTrace();
        }
    }

    public static void c() {
        try (BufferedReader in = Files.newBufferedReader(Paths.get("abc"), StandardCharsets.UTF_8)) {
            in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }
}
