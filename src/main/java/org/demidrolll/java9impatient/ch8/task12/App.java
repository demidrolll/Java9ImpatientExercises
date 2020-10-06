package org.demidrolll.java9impatient.ch8.task12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Your manager asks you to write a method public static <T> boolean
 * isFinite(Stream<T> stream). Why isn’t that such a good idea? Go ahead and
 * write it anyway.
 */
public class App {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        Stream<String> stream = list.stream();
        isFinite(stream);

        // exception here: closed stream
        isFinite(stream);
    }

    public static <T> boolean isFinite(Stream<T> stream) {
        return stream.count() == 0;
    }

}
