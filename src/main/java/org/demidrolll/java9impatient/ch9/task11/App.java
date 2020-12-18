package org.demidrolll.java9impatient.ch9.task11;

import java.util.regex.Pattern;

/**
 * Using regular expressions, extract the directory path names (as an array
 * of strings), the file name, and the file extension from an absolute or
 * relative path such as /home/cay/myfile.txt.
 */
public class App {

    private static final Pattern DIR_PATTERN = Pattern.compile("");
    private static final Pattern FILE_NAME_PATTERN = Pattern.compile("");
    private static final Pattern FILE_EXT_PATTERN = Pattern.compile("");

    public static void main(String[] args) {
        String path = "/home/cay/myfile.txt";
        String[] dirs = DIR_PATTERN.split()
    }
}
