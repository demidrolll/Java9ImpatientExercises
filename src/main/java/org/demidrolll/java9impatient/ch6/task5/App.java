package org.demidrolll.java9impatient.ch6.task5;

import java.util.Arrays;

/**
 * Consider this variant of the swap method where the array can be supplied
 * with varargs.
 * Now have a look at the call
 * Double[] result = Arrays.swap(0, 1, 1.5, 2, 3);
 * What error message do you get? Now call
 * Double[] result = Arrays.<Double>swap(0, 1, 1.5, 2, 3);
 * Has the error message improved? What do you do to fix the problem?
 */

public class App {
    public static void main(String[] args) {
        //Double[] result = App.swap(0, 1, 1.5, 2, 3);

        Number[] result1 = App.swap(0, 1, 1.5, 2, 3);
        System.out.println(Arrays.toString(result1));

        Double[] result2 = App.swap(0, 1, 1.5, 2.0, 3.0);
        System.out.println(Arrays.toString(result2));
    }

    @SafeVarargs
    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }
}
