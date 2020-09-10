package org.demidrolll.java9impatient.ch1;

import java.util.Scanner;

public class Task_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String buf = in.nextLine();
        String[] words = buf.split("\\s+");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
