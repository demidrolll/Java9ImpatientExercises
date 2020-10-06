package org.demidrolll.java9impatient.ch8.task14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * Join all elements in a Stream<ArrayList<T>> to one ArrayList<T>. Show how to
 * do this with each of the three forms of reduce.
 */
public class App {

    public static void main(String[] args) {
        ArrayList<String> source1 = new ArrayList<>();
        source1.add("a");
        source1.add("b");
        ArrayList<String> source2 = new ArrayList<>();
        source1.add("c");
        source1.add("d");
        ArrayList<String> source3 = new ArrayList<>();
        source1.add("e");
        source1.add("f");
        List<ArrayList<String>> list = new ArrayList<>();
        list.add(source1);
        list.add(source2);
        list.add(source3);
        ArrayList<String> result;

        result = joinOne(list.stream());
        System.out.println(result);

        result = joinTwo(list.stream());
        System.out.println(result);

        result = joinThree(list.stream());
        System.out.println(result);
    }

    public static <T> ArrayList<T> joinOne(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<>(), App::joinList);
    }

    public static <T> ArrayList<T> joinTwo(Stream<ArrayList<T>> stream) {
        return stream.reduce(App::joinList).orElse(new ArrayList<>());
    }

    public static <T> ArrayList<T> joinThree(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<>(),
                App::joinList,
                App::joinList);
    }

    public static <E, T extends ArrayList<E>> T joinList(T a, T b) {
        a.addAll(b);
        return a;
    }
}
