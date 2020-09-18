package org.demidrolll.java9impatient.ch5.task2;

import org.demidrolll.java9impatient.ch5.task1.CastException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a method public double sumOfValues(String filename) throws ... that calls
 * the preceding method and returns the sum of the values in the file.
 * Propagate any exceptions to the caller.
 */

public class App {

    public double sumOfValues(String filename) throws FileNotFoundException, CastException {
        ArrayList<Double> list =
                new org.demidrolll.java9impatient.ch5.task1.App().readValues(filename);
        return list.stream().reduce(Double::sum).orElse(0.00);
    }
}
