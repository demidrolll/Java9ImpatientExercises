package org.demidrolll.java9impatient.ch9.task3;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Write a program that reads a file containing text and, assuming that most
 * words are English, guesses whether the encoding is ASCII, ISO 8859-1,
 * UTF-8, or UTF-16, and if the latter, which byte ordering is used.
 */
public class App {
    public static void main(String[] args) {
        guessEncoding("alice.txt", StandardCharsets.UTF_16.name());
    }

    private static boolean guessEncoding(String filename, String encoding) {
        try (InputStream rawIn = Files.newInputStream(Paths.get(filename));
             BufferedReader textIn = Files.newBufferedReader(Paths.get(filename), Charset.forName(encoding))) {

            byte[] rawBytes = rawIn.readAllBytes();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(out, encoding);

            return Arrays.compare(rawBytes, out.toByteArray()) == 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
