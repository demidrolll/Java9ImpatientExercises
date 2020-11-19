package org.demidrolll.java9impatient.ch9.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Using a Scanner is convenient, but it is a bit slower than using a
 * BufferedReader. Read in a long file a line at a time, counting the number of
 * input lines, with (a) a Scanner and hasNextLine/nextLine, (b) a BufferedReader and
 * readLine, (c) a BufferedReader and lines. Which is the fastest? The most
 * convenient?
 */
public class App {
    public static void main(String[] args) {
        System.out.println("time a: " +
                measureTime(() -> readWithScanner("alice.txt")));
        System.out.println("time b: " +
                measureTime(() -> readWithReadLineBufferedReader("alice.txt")));
        System.out.println("time c: " +
                measureTime(() -> readWithLinesBufferedReader("alice.txt")));
    }

    private static long readWithScanner(String filename) {
        int lineCount = 0;
        try (Scanner in = new Scanner(Paths.get(filename), StandardCharsets.UTF_8.name())) {
            while (in.hasNextLine()) {
                in.nextLine();
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }

    private static long readWithReadLineBufferedReader(String filename) {
        int lineCount = 0;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8)) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }

    private static long readWithLinesBufferedReader(String filename) {
        long lineCount = 0;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8)) {
            lineCount = reader.lines().count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }

    private static long measureTime(Runnable action) {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            action.run();
        }
        return (System.nanoTime() - startTime) / 10;
    }
}
