package org.demidrolll.java9impatient.ch4.task3.main;

import org.demidrolll.java9impatient.ch4.task3.LabeledPoint;

/**
 * Make the instance variables x and y of the Point class in Exercise 1 protected.
 * Show that the LabeledPoint class can access these variables only in LabeledPoint
 * instances.
 */

public class App {
    public static void main(String[] args) {
        LabeledPoint a = new LabeledPoint("A", 10, 20);
        // System.out.println(a.x); no access from another package
        System.out.println(a);
    }
}
