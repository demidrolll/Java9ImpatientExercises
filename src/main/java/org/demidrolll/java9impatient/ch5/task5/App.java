package org.demidrolll.java9impatient.ch5.task5;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Implement a method that contains the code with a Scanner and a PrintWriter
 * in Section 5.1.5, “The Try-with-Resources Statement” (page 187). But don’t
 * use the try-with-resources statement. Instead, just use catch clauses. Be
 * sure to close both objects, provided they have been properly constructed.
 */

public class App {
    public static void main(String[] args) throws IOException {
        simpleTryCatch();
    }

    public static void tryWithResources() throws IOException {
        try (Scanner in = new Scanner(Paths.get("words.txt"));
             PrintWriter out = new PrintWriter("output2.txt")) {
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        }
    }

    public static void simpleTryCatch() throws IOException {
        Scanner in = null;
        PrintWriter out = null;
        Throwable commonEx = null;
        try {
            in = new Scanner(Paths.get("words.txt"));
            out = new PrintWriter("output2.txt");
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
                // throw new IllegalStateException("has next exception");
            }
        } catch (Throwable ex) {
            commonEx = ex;
            throw ex;
        } finally {
            if (out != null) {
                try {
                    out.close();
                    // throw new IOException("close out exception");
                } catch (Throwable ex) {
                    if (commonEx != null) {
                        commonEx.addSuppressed(ex);
                    }
                }
            }
            if (in != null) {
                try {
                    in.close();
                    // throw new IOException("close in exception");
                } catch (Throwable ex) {
                    if (commonEx != null) {
                        commonEx.addSuppressed(ex);
                    }
                }
            }
        }
    }
}
