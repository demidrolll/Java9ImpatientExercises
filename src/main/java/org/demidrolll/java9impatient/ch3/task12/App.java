package org.demidrolll.java9impatient.ch3.task12;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        scan("d:\\bin\\exe\\grd30\\debug\\Admin\\", "BLK");
    }

    public static void scan(String path, String ext) {
        String[] files = new File(path).list((dir, name) -> name.endsWith("." + ext));
        System.out.println(Arrays.toString(files));
    }
}
