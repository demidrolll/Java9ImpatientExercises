package org.demidrolll.java9impatient.ch9.task7;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Look up the API documentation for the MessageDigest class and write a
 * program that computes the SHA-512 digest of a file. Feed blocks of bytes
 * to the MessageDigest object with the update method, then display the result
 * of calling digest. Verify that your program produces the same result as the
 * sha512sum utility.
 */
public class App {
    public static void main(String[] args) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] data = Files.readAllBytes(Paths.get("image.bmp"));
            byte[] hash = digest.digest(data);
            System.out.println(bytesToHex(hash));
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
