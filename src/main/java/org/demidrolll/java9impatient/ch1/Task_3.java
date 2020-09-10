package org.demidrolll.java9impatient.ch1;

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("one: ");
        int one = in.nextInt();
        System.out.print("two: ");
        int two = in.nextInt();
        System.out.print("three: ");
        int three = in.nextInt();

        int maxInt = one;
        if (two > maxInt) {
            maxInt = two;
        }
        if (three > maxInt) {
            maxInt = three;
        }

        System.out.println("max 1: " + maxInt);

        maxInt = Math.max(one, two);
        maxInt = Math.max(maxInt, three);
        System.out.println("max 2: " + maxInt);
    }
}
