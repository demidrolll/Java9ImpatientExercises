package org.demidrolll.java9impatient.ch8.task1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Verify that asking for the first five long words does not call the filter
 * method once the fifth long word has been found. Simply log each
 * method call.
 */

public class App {
    public static void main(String[] args) throws IOException {
        String contents = new String(
                Files.readAllBytes(Paths.get("alice.txt")),
                StandardCharsets.UTF_8
        );
        List<String> words = Arrays.stream(contents.split("\\PL+")).collect(Collectors.toList());

        System.out.println("start");
        List<String> filtered = words.stream()
                .filter(w -> {
                    System.out.println("call filter");
                    return w.length() > 8;
                })
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("long words count: " + filtered.size());
    }
}
