package org.demidrolll.java9impatient.ch5.task2;

import org.demidrolll.java9impatient.ch5.task1.CastException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public double sumOfValues(String filename) throws FileNotFoundException, CastException {
        ArrayList<Double> list =
                new org.demidrolll.java9impatient.ch5.task1.App().readValues(filename);
        return list.stream().reduce(Double::sum).orElse(0.00);
    }
}
