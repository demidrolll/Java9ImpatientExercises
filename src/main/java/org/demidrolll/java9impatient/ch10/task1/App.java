package org.demidrolll.java9impatient.ch10.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Using parallel streams, find all files in a directory that contain a given
 * word. How do you find just the first one? Are the files actually searched
 * concurrently?
 */
public class App {
    public static void main(String[] args) {
        try {
            Long time = System.currentTimeMillis();
            List<Path> files = Files
                    .walk(Paths.get("c:\\wildfly\\wildfly-18.0.1.Final\\standalone\\log\\"))
                    .parallel() // ??? I am not sure, no difference without parallel
                    .filter(Files::isRegularFile)
                    .filter(path -> {
                        try {
                            boolean exist = Files.lines(path).anyMatch(line -> line.contains("IB_USER_INFO"));
                            System.out.println(path + ": " + exist);
                            return exist;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return false;
                        }
                    })
                    .collect(Collectors.toList());
            System.out.println("Total count: " + files.size() + " time: " + (System.currentTimeMillis() - time));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
