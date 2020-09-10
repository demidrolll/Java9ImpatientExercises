package org.demidrolll.java9impatient.ch1;

import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter angle: ");
        int angle = in.nextInt();
        System.out.println("normalized angle: " + angle % 360);
        System.out.println("normalized angle: " + Math.floorMod(angle, 360));
    }
}
