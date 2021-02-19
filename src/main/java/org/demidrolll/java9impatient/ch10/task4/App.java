package org.demidrolll.java9impatient.ch10.task4;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 One parallel operation not discussed in Section 10.4.2, “Parallel Array
 Operations” (page 349) is the parallelPrefix method that replaces each array
 element with the accumulation of the prefix for a given associative operation.
 Huh? Here is an example. Consider the array [1, 2, 3, 4, ...] and
 the × operation. After executing Arrays.parallelPrefix(values, (x, y) -> x * y),
 the array contains

   [1, 1 × 2, 1 × 2 × 3, 1 × 2 × 3 × 4, ...]

 Perhaps surprisingly, this computation can be parallelized. First, join
 neighboring elements, as indicated here:

   [1, 1 × 2, 3, 3 × 4, 5, 5 × 6, 7, 7 × 8]

 The gray values are left alone. Clearly, one can make this computation
 concurrently in separate regions of the array. In the next step, update the
 indicated elements by multiplying them with elements that are one or
 two positions below:

   [1, 1 × 2, 1 × 2 × 3, 1 × 2 × 3 × 4, 5, 5 × 6, 5 × 6 × 7, 5 × 6 × 7 × 8]

 This can again be done concurrently. After log(n) steps, the process is
 complete. This is a win over the straightforward linear computation if
 sufficient processors are available.
 In this exercise, you will use the parallelPrefix method to parallelize the
 computation of Fibonacci numbers. We use the fact that the nth Fibonacci
 number is the top left coefficient of Fn, where

 F = ( 1 1
       1 0 )

 Make an array filled with 2 × 2 matrices. Define a Matrix class with a multiplication
 method, use parallelSetAll to make an array of matrices, and use
 parallelPrefix to multiply them.
 */
public class App {
    public static void main(String[] args) {
        Matrix m = new Matrix(2, 2);
        m.set(0, 0, BigDecimal.ONE);
        m.set(0, 1, BigDecimal.ONE);
        m.set(1, 0, BigDecimal.ONE);
        m.set(1, 1, BigDecimal.ZERO);
        System.out.println(m);

        Matrix[] list = new Matrix[200];
        Arrays.parallelSetAll(list, i -> m);
        Arrays.parallelPrefix(list, Matrix::multiply);

        Arrays.stream(list).forEachOrdered(item -> System.out.print(item.get(0, 0) + " "));
    }
}
