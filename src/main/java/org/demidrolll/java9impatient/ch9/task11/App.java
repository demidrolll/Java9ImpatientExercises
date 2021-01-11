package org.demidrolll.java9impatient.ch9.task11;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Using regular expressions, extract the directory path names (as an array
 * of strings), the file name, and the file extension from an absolute or
 * relative path such as /home/cay/myfile.txt.
 */
public class App {

    public static void main(String[] args) {
        String dirsPath = "home/cay/";
        String relativePath = "/home/cay/myfile.txt";
        String absolutePath = "C:/home/cay/myfile.txt";
        String fileOnlyPath = "C:/myfile.txt";

        show(dirsPath);
        show(relativePath);
        show(absolutePath);
        show(fileOnlyPath);
    }

    private static void show(String path) {
        System.out.println(MessageFormat.format(
                "path: {4}\nroot: {0}\ndirs: {1}\nfile name: {2}\nfile ext: {3}\n",
                extractRoot(path), Arrays.toString(extractDir(path)), extractFileName(path), extractFileExt(path), path));
    }

    private static class ParsedPath {
        private String root;
        private final List<String> dirs = new ArrayList<>();
        private String fullFileName;
        private String fileName;
        private String fileExt;
    }

    private static ParsedPath parsePath(String path) {
        ParsedPath parsedPath = new ParsedPath();

        // root and dirs
        Matcher matcher = Pattern.compile("[^/]*/").matcher(path);
        int start = 0;
        int groupIndex = 0;
        while (matcher.find(start)) {
            String item = matcher.group();
            String addItem = item.replace("/", "");

            if (groupIndex == 0) {
                // may be root
                if ("/".equals(item) || item.contains(":")) {
                    parsedPath.root = addItem;
                } else {
                    parsedPath.dirs.add(addItem);
                }
            } else {
                parsedPath.dirs.add(addItem);
            }
            start = matcher.end();
            groupIndex++;
        }

        // filename
        matcher = Pattern.compile(".+").matcher(path);
        if (matcher.find(start)) {
            parsedPath.fullFileName = matcher.group();
        }

        if (parsedPath.fullFileName != null) {
            matcher = Pattern.compile("(.+[.]*)([.]+.+)").matcher(parsedPath.fullFileName);
            if (matcher.find()) {
                parsedPath.fileName = matcher.group(1);
                parsedPath.fileExt = matcher.group(2);
                if (parsedPath.fileExt != null) {
                    parsedPath.fileExt = parsedPath.fileExt.replace(".", "");
                }
            }
        }

        return parsedPath;
    }

    private static String extractRoot(String path) {
        return parsePath(path).root;
    }

    private static String[] extractDir(String path) {
        return parsePath(path).dirs.toArray(new String[0]);
    }

    private static String extractFileName(String path) {
        return parsePath(path).fileName;
    }

    private static String extractFileExt(String path) {
        return parsePath(path).fileExt;
    }
}
