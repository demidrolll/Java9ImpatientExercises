package org.demidrolll.java9impatient.ch8.task8;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Find a realistic use for the Collectors.flatMapping method. Consider some
 * class with a method yielding an Optional. Then group by some characteristic
 * and, for each group, collect the nonempty optional values by using
 * flatMapping and Optional.stream.
 */
public class App {
    public static void main(String[] args) {
        String[] list = new String[] {"Hello", "My", "World", "Hello"};
        Map<String, Long> map = Stream.of(list).collect(
                Collectors.groupingBy(String::toString,
                        Collectors.flatMapping(s -> App.extractChar(s, 'o').stream(), Collectors.counting()))
        );
        System.out.println(map);
    }

    public static Optional<String> extractChar(String s, char ch) {
        int i;
        return (i = s.indexOf(ch)) > 0 ? Optional.of(String.valueOf(s.charAt(i))) : Optional.empty();
    }
}
