package org.demidrolll.java9impatient.ch5.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a method public ArrayList<Double> readValues(String filename) throws ... that
 * reads a file containing floating-point numbers. Throw appropriate excep-
 * tions if the file could not be opened or if some of the inputs are not
 * floating-point numbers.
 */

public class App {

    public static void main(String[] args) {
        App app = new App();
        try {
            ArrayList<Double> list = app.readValues("in.txt");
            System.out.println(list);
        } catch (FileNotFoundException | CastException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<Double> readValues(String fileName) throws FileNotFoundException, CastException {
        ArrayList<Double> list = new ArrayList<>();
        try (Scanner in = new Scanner(new File(fileName))) {
            while (in.hasNext()) {
                String arg = in.next();
                try {
                    list.add(Double.valueOf(arg));
                } catch (NumberFormatException ex) {
                    throw new CastException("no double value " + arg);
                }
            }
        }
        return list;
    }
}
