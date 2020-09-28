package org.demidrolll.java9impatient.ch8.task4;

import java.util.stream.Stream;

/**
 * Using Stream.iterate, make an infinite stream of random numbers—not by
 * calling Math.random but by directly implementing a linear congruential generator.
 * In such a generator, you start with x0 = seed and then produce xn + 1 = (a
 * xn + c) % m, for appropriate values of a, c, and m. You should implement
 * a method with parameters a, c, m, and seed that yields a Stream<Long>. Try
 * out a = 25214903917, c = 11, and m = 2^48
 */

public class App {
    public static void main(String[] args) {
        long a = 25214903917L;
        int c = 11;
        double m = Math.pow(2.00, 48);
        Stream
                .iterate(System.currentTimeMillis(), x -> Math.round((a * x + c) % m))
                .forEach(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(i);
                });
    }
}
