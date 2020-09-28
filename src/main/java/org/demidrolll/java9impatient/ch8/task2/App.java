package org.demidrolll.java9impatient.ch8.task2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws IOException {
        String contents = new String(
                Files.readAllBytes(Paths.get("war-and-peace.txt")),
                StandardCharsets.UTF_8
        );
        List<String> words = Arrays.stream(contents.split("\\PL+")).collect(Collectors.toList());

        // difference only in large source
        run(words.stream()); // 14 ms
        run(words.parallelStream()); // 8 ms
    }

    public static void run(Stream<String> stream) {
        long time = System.nanoTime();
        long count = stream
                .filter(w -> w.length() > 10)
                .count();
        time = System.nanoTime() - time;
        System.out.println("words: " + count);
        System.out.println("elapsed time: " + time);
    }
}
