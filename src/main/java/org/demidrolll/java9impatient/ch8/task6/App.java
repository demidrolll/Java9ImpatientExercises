package org.demidrolll.java9impatient.ch8.task6;

/**
 * Use the String.codePoints method to implement a method that tests whether
 * a string is a word, consisting only of letters. (Hint: Character.isAlphabetic.)
 * Using the same approach, implement a method that tests whether a string
 * is a valid Java identifier.
 */

public class App {
    public static void main(String[] args) {
        System.out.println(isLetters(""));
        System.out.println(isLetters("a1z"));
        System.out.println(isLetters("abc"));

        System.out.println(isValidIdentifier(""));
        System.out.println(isValidIdentifier("geek@"));
        System.out.println(isValidIdentifier("123geeks"));
        System.out.println(isValidIdentifier("a+c"));
        System.out.println(isValidIdentifier("sum_&_difference"));

        System.out.println(isValidIdentifier("MyVariable"));
        System.out.println(isValidIdentifier("_myvariable"));
        System.out.println(isValidIdentifier("$myvariable"));
        System.out.println(isValidIdentifier("sum_of_array"));
        System.out.println(isValidIdentifier("geeks123"));
    }

    public static boolean isLetters(String s) {
        return s != null
                && !s.isEmpty()
                && s.codePoints().allMatch(Character::isAlphabetic);
    }

    public static boolean isValidIdentifier(String s) {
        return s != null
                && !s.isEmpty()
                && s.codePoints().limit(1).allMatch(Character::isJavaIdentifierStart)
                && s.codePoints().skip(1).allMatch(Character::isJavaIdentifierPart);
    }
}
