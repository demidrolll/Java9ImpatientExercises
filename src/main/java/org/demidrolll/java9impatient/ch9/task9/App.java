package org.demidrolll.java9impatient.ch9.task9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Using the URLConnection class, read data from a password-protected web
 * page with “basic” authentication. Concatenate the user name, a colon,
 * and the password, and compute the Base64 encoding:
 * <p>
 * String input = username + ":" + password;
 * String encoding = Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
 * <p>
 * Set the HTTP header Authorization to the value "Basic " + encoding. Then read
 * and print the page contents.
 */
public class App {
    public static void main(String[] args) {
        URLConnection connection = null;
        try {
            URL url = new URL("https://github.com/demidrolll/Java9ImpatientExercises");
            connection = url.openConnection();

            String credentials = "demidrolll:password";
            String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);
            System.out.println(connection.getRequestProperties());

            try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                System.out.println(connection.getHeaderFields());

                reader.lines().forEach(System.out::println);
            }
        } catch (IOException e) {
            if (connection != null) {
                System.out.println(connection.getHeaderFields());
            }
            e.printStackTrace();
        }
    }
}
