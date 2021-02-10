package org.demidrolll.java9impatient.ch10.task3;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Implement a method yielding a task that reads through all words in a
 * file, trying to find a given word. The task should finish immediately (with
 * a debug message) when it is interrupted. For all files in a directory,
 * schedule one task for each file. Interrupt all others when one of them
 * has succeeded.
 */
public class App {
    public static void main(String[] args) {

        String searchWord = "test";
        Executor executor = Executors.newCachedThreadPool();
        try {
            Files
                    .walk(Paths.get("c:\\wildfly\\wildfly-18.0.1.Final\\standalone\\log\\"))
                    .filter(Files::isRegularFile)
                    .forEach(path ->
                            executor.execute(() -> {
                                System.out.println("start read file " + path);
                                if (Thread.currentThread().isInterrupted()) {
                                    System.out.println("Thread for file " + path + " is interrupted");
                                    return;
                                }
                                try {
                                    boolean existWord = Files
                                            .lines(path, StandardCharsets.UTF_8)
                                            .flatMap(line -> Arrays.stream(line.split("[\\s\\t\\n\\r\\f]")))
                                            .anyMatch(searchWord::equalsIgnoreCase);
                                    if (existWord) {
                                        Thread.currentThread().interrupt();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                System.out.println("done read file " + path);
                            })
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
