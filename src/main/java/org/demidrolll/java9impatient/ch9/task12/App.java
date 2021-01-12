package org.demidrolll.java9impatient.ch9.task12;

import java.util.regex.Pattern;

/**
 * Come up with a realistic use case for using group references in
 * Matcher.replaceAll and implement it
 */
public class App {
    public static void main(String[] args) {
        Pattern commas = Pattern.compile(" ");
        String csv = commas.matcher("Hello my world").replaceAll("|");
        System.out.println(csv);

        Pattern badWords = Pattern.compile("(sex|drug[s]*)");
        String corrected = badWords.matcher("Bad guys like sex, drugs and rock&roll").replaceAll("*censored*");
        System.out.println(corrected);
    }
}
