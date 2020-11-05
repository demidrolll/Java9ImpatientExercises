package org.demidrolll.java9impatient.ch9.task2;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a program that reads a text file and produces a file with the same
 * name but extension .toc, containing an alphabetized list of all words in
 * the input file together with a list of line numbers in which each word
 * occurs. Assume that the file’s encoding is UTF-8.
 */
public class App {

    public static void main(String[] args) {
        String fileName = "alice.txt";
        Path src = Paths.get(fileName);
        Path dst = src.resolveSibling(replaceExtension(src.getFileName().toString(), "toc"));
        try (BufferedReader in = Files.newBufferedReader(src, StandardCharsets.UTF_8);
             BufferedWriter out = Files.newBufferedWriter(dst, StandardCharsets.UTF_8)) {

            Pattern pattern = Pattern.compile("\\s*[\\.;:,!\\h\\(\\)\\`\\?\\*\\[\\]\"]{1}\\s*");
            String line = null;
            int number = 0;
            Map<String, Set<Integer>> result = new TreeMap<>();
            while ((line = in.readLine()) != null) {
                number++;
                for (String word : pattern.split(line)) {
                    word = word.replaceAll("--", "");
                    if (word.isEmpty() || word.length() < 3) {
                        continue;
                    }
                    word = word.toUpperCase();
                    result.computeIfAbsent(word, k -> new TreeSet<>()).add(number);
                }
            }

            result.entrySet().stream().forEachOrdered(e -> {
                try {
                    out.write(e.toString());
                    out.write("\n");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String replaceExtension(String filename, String newExtension) {
        int extInd = filename.lastIndexOf(".");
        if (extInd >= 0) {
            filename = filename.substring(0, extInd);
        }
        return filename + "." + newExtension;
    }
}
