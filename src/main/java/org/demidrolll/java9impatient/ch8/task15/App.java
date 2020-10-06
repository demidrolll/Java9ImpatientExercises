package org.demidrolll.java9impatient.ch8.task15;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Stream;

/**
 * Write a call to reduce that can be used to compute the average of a
 * Stream<Double>. Why can’t you simply compute the sum and divide by count()?
 */
public class App {

    public static void main(String[] args) {
        Double result = Stream.of(1.0, 2.0, 3.0)
                .reduce(new DoubleSummaryStatistics(), App::accumulator, App::combine)
                .getAverage();
        System.out.println(result);
    }

    private static DoubleSummaryStatistics accumulator(DoubleSummaryStatistics stat, Double value) {
        stat.accept(value);
        return stat;
    }

    private static DoubleSummaryStatistics combine(DoubleSummaryStatistics one, DoubleSummaryStatistics two) {
        one.combine(two);
        return one;
    }
}
