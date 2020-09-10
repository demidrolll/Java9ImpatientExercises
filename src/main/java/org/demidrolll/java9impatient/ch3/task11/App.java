package org.demidrolll.java9impatient.ch3.task11;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        //scan("d:\\bin\\exe\\grd30\\debug\\", 0);
        scanAnonim("d:\\bin\\exe\\grd30\\debug\\", 0);
    }

    public static void scan(String path, int level) {
        File file = new File(path);
        File[] directories = Arrays.stream(file.listFiles())
                .filter(File::isDirectory)
                .toArray(File[]::new);

        for (File dir : directories) {
            for (int i = 0; i < level; i++) {
                System.out.print(" ");
            }
            System.out.println(dir.toPath().getFileName());
            scan(dir.getPath(), level + 2);
        }
    }

    public static void scanAnonim(String path, int level) {
        File file = new File(path);
        File[] directories = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        for (File dir : directories) {
            for (int i = 0; i < level; i++) {
                System.out.print(" ");
            }
            System.out.println(dir.toPath().getFileName());
            scan(dir.getPath(), level + 2);
        }
    }
}
