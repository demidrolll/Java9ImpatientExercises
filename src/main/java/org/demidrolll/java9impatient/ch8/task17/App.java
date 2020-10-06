package org.demidrolll.java9impatient.ch8.task17;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Find the 500 longest strings in War and Peace with a parallel stream. Is it
 * any faster than using a serial stream?
 */
public class App {
    public static void main(String[] args) {
            try {
                long time = System.nanoTime();
                List<String> result = null;
                for (int i = 0; i < 10; i++) {
                    result = Files
                            .lines(Paths.get("WarAndPeace.txt"), Charset.forName("Windows-1252"))
                            .parallel()
                            .flatMap(s -> Arrays.stream(s.split("\\PL+")))
                            .filter(org.demidrolll.java9impatient.ch8.task6.App::isLetters)
                            .distinct()
                            .collect(Collectors.groupingBy(String::length))
                            .entrySet()
                            .stream()
                            .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                            .flatMap(entry -> entry.getValue().stream())
                            .limit(500)
                            .collect(Collectors.toList());
                }
                time = (System.nanoTime() - time) / 10;
                System.out.println("time: " + time);
                System.out.println(result);

                // sequential time 195697879
                // parallel time 158629673
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
