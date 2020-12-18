package org.demidrolll.java9impatient.ch9.task10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Using a regular expression, extract all decimal integers (including negative
 * ones) from a string into an ArrayList<Integer> (a) using find, and (b) using
 * split. Note that a + or - that is not followed by a digit is a delimiter.
 */
public class App {

    private static final Pattern DIGITS_PATTERN = Pattern.compile("[+\\- ]\\d+");

    public static void main(String[] args) {
        String digits = "+1-12+- 33 55 -10-";
        System.out.println(extractA(digits));
        System.out.println(extractB(digits));
        System.out.println(extractC(digits));
    }

    public static ArrayList<Integer> extractA(String digits) {
        ArrayList<Integer> result = new ArrayList<>();
        Matcher matcher = DIGITS_PATTERN.matcher(digits);
        while (matcher.find()) {
            String match = matcher.group().trim();
            result.add(Integer.valueOf(match));
        }
        return result;
    }

    // todo valid parse sign of digit
    public static List<Integer> extractB(String digits) {
        return Arrays.stream(digits.split("[+\\- ]+"))
                .filter(s -> s.trim().length() > 0)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static List<Integer> extractC(String digits) {
        return DIGITS_PATTERN.matcher(digits)
                .results()
                .map(match -> Integer.valueOf(match.group().trim()))
                .collect(Collectors.toList());
    }
}
