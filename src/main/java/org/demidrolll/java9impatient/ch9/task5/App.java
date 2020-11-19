package org.demidrolll.java9impatient.ch9.task5;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * When an encoder of a Charset with partial Unicode coverage can’t encode
 * a character, it replaces it with a default—usually, but not always, the encoding
 * of "?". Find all replacements of all available character sets that
 * support encoding. Use the newEncoder method to get an encoder, and call
 * its replacement method to get the replacement. For each unique result, report
 * the canonical names of the charsets that use it.
 */
public class App {
    public static void main(String[] args) {
        Map<String, Integer> replacements = Charset.availableCharsets().values().stream()
                .map(charset -> {
                    CharsetEncoder encoder;
                    try {
                        encoder = charset.newEncoder();
                    } catch (UnsupportedOperationException ex) {
                        encoder = null;
                    }
                    if (encoder != null) {
                        return new String(encoder.replacement());
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(String::toString, s -> 1, Integer::sum));

        System.out.println(replacements);
    }
}
