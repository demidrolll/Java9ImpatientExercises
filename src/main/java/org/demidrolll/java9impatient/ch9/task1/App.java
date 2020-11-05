package org.demidrolll.java9impatient.ch9.task1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

/**
 * Write a utility method for copying all of an InputStream to an OutputStream,
 * without using any temporary files. Provide another solution, without a
 * loop, using operations from the Files class, using a temporary file.
 */
public class App {
    public static void main(String[] args) {
        try (InputStream in = Files.newInputStream(Paths.get("alice.txt"), StandardOpenOption.READ);
             OutputStream out = Files.newOutputStream(Paths.get("alice_copy.txt"), StandardOpenOption.CREATE)) {
            // copy(in, out);
            // copyTemp(in, out);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void copy(InputStream in, OutputStream out) throws IOException {
        in.transferTo(out);
    }

    public static void copyTemp(InputStream in, OutputStream out) throws IOException {
        Path tmp = Files.createTempFile("", "");
        Files.copy(in, tmp, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(tmp, out);
        Files.deleteIfExists(tmp);
    }

}
