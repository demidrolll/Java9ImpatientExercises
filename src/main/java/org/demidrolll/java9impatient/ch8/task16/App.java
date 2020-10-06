package org.demidrolll.java9impatient.ch8.task16;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Find 500 prime numbers with 50 decimal digits, using a parallel stream
 * of BigInteger and the BigInter.isProbablePrime method. Is it any faster than
 * using a serial stream?
 */
public class App {
    public static void main(String[] args) {
        // long time = System.nanoTime();
        // for (int i = 0; i < 10; i++) {
            List<BigInteger> result = Stream
                    .iterate(BigInteger.valueOf(10).pow(50), v -> v.add(BigInteger.valueOf(1)))
                    // .parallel()
                    .filter(v -> v.isProbablePrime(1))
                    .limit(500)
                    .collect(Collectors.toList());

        // }
        // time = (System.nanoTime() - time) / 10;
        // System.out.println("time: " + time);
        System.out.println(result);
    }
}
