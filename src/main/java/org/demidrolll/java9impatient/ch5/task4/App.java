package org.demidrolll.java9impatient.ch5.task4;

import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Repeat the preceding exercise, but don’t use exceptions. Instead, have
 * readValues and sumOfValues return error codes of some kind.
 */

public class App {
    public static void main(String[] args) {
        Pair<Integer, Double> result = sumOfValues("in.txt");
        switch (result.getKey()) {
            case 0:
                System.out.println(result.getValue());
                break;
            case 1:
                System.out.println("file not found");
                break;
            case 2:
                System.out.println("bad value");
                break;
            default:
                break;
        }
    }

    public static Pair<Integer, ArrayList<Double>> readValues(String filename) {
        ArrayList<Double> list = new ArrayList<>();
        try (Scanner in = new Scanner(new File(filename))) {
            while (in.hasNext()) {
                String arg = in.next();
                list.add(Double.valueOf(arg));
            }
        } catch (FileNotFoundException e) {
            return new Pair<>(1, list);
        } catch (NumberFormatException e) {
            return new Pair<>(2, list);
        }
        return new Pair<>(0, list);
    }

    public static Pair<Integer, Double> sumOfValues(String filename) {
        Pair<Integer, ArrayList<Double>> result = readValues("in.txt");
        if (result.getKey() == 0) {
           Double sum = result.getValue().stream().reduce(Double::sum).orElse(0.00);
           return new Pair<>(0, sum);
        } else {
            return new Pair<>(result.getKey(), 0.00);
        }
    }
}
