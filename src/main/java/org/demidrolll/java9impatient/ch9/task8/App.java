package org.demidrolll.java9impatient.ch9.task8;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Write a utility method for producing a ZIP file containing all files from
 * a directory and its descendants.
 */
public class App {
    public static void main(String[] args) throws URISyntaxException {
        zipDirectory("d:\\test", "books.zip");
    }

    public static void zipDirectory(String dir, String zipName) throws URISyntaxException {
        Path arch = Paths.get(zipName);
        URI uri = new URI("jar", arch.toUri().toString(), null);
        try (FileSystem zipfs = FileSystems.newFileSystem(uri, Map.of("create", "true"))) {
            Path zipRoot = zipfs.getPath("/");
            Stream<Path> files = Files.walk(Paths.get(dir));
            files
                    .filter(Files::isRegularFile)
                    .forEach(src -> {
                        Path dst = src.getRoot().relativize(src);
                        dst = zipRoot.resolve(zipfs.getPath(dst.toString()));
                        try {
                            Files.createDirectories(dst.getParent());
                            Files.copy(src, dst);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
