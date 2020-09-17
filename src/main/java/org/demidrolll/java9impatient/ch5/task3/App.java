package org.demidrolll.java9impatient.ch5.task3;

import org.demidrolll.java9impatient.ch5.task1.CastException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try {
            Double sum = new org.demidrolll.java9impatient.ch5.task2.App().sumOfValues("in.txt");
            System.out.println(sum);
        } catch (FileNotFoundException | CastException e) {
            e.printStackTrace();
        }
    }

}
