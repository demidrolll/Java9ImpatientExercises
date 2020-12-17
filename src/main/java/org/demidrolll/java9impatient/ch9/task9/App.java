package org.demidrolll.java9impatient.ch9.task9;

/**
 * Using the URLConnection class, read data from a password-protected web
 * page with “basic” authentication. Concatenate the user name, a colon,
 * and the password, and compute the Base64 encoding:
 *
 * String input = username + ":" + password;
 * String encoding = Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
 *
 * Set the HTTP header Authorization to the value "Basic " + encoding. Then read
 * and print the page contents.
 */
public class App {
    public static void main(String[] args) {
    }
}
