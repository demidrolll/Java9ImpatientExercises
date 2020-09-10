package org.demidrolll.java9impatient.ch1;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter digit: ");
        int digit = in.nextInt();

        System.out.printf("binary: %s\n", Integer.toString(digit, 2));
        System.out.printf("octal: %#o\n", digit);
        System.out.printf("hex: %#X\n", digit);
    }
}
