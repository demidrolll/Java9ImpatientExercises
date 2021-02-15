package org.demidrolll.java9impatient.ch10.task3;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Implement a method yielding a task that reads through all words in a
 * file, trying to find a given word. The task should finish immediately (with
 * a debug message) when it is interrupted. For all files in a directory,
 * schedule one task for each file. Interrupt all others when one of them
 * has succeeded.
 */
public class App {
    public static void main(String[] args) {

        String word = "metadata_access_type";
        ExecutorService executor = Executors.newFixedThreadPool(4);

        try {
            List<Runnable> tasks = Files
                    .walk(Paths.get("c:\\wildfly\\wildfly-18.0.1.Final\\standalone\\log\\"))
                    .filter(Files::isRegularFile)
                    .map(path -> App.searchWord(path, word, executor))
                    .collect(Collectors.toList());

            for (Runnable task : tasks) {
                executor.submit(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("stop program");
    }

    private static Runnable searchWord(Path path, String word, ExecutorService executor) {
        return () -> {
            System.out.println("start read file " + path);
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted thread for file " + path);
                return;
            }
            try {
                boolean existWord = Files
                        .lines(path, StandardCharsets.UTF_8)
                        .flatMap(line -> Arrays.stream(line.split("[\\s\\t\\n\\r\\f]")))
                        .anyMatch(word::equalsIgnoreCase);
                if (existWord) {
                    System.out.println("Word was found in " + path);
                    executor.shutdownNow();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("done read file " + path);
        };
    }

}
