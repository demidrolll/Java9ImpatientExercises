package org.demidrolll.java9impatient.ch3.task6;

import java.util.Comparator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Sequence seq = new SquareSequence();
        while (seq.hasNext()) {
            System.out.println(seq.next());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
