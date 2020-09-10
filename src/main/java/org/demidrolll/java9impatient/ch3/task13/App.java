package org.demidrolll.java9impatient.ch3.task13;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class App {

    public static void main(String[] args) {

        File file = new File("c:\\");
        File[] fileList = file.listFiles();
        Comparator<File> comp = Comparator
                .comparing(File::isDirectory, (isDir1, isDir2) -> isDir1 == isDir2 ? 0 : isDir1 ? -1 : 1)
                .thenComparing(File::getPath, String::compareTo);

        Arrays.sort(fileList, comp);
        for (File f : fileList) {
            System.out.println(f);
        }
    }
}
