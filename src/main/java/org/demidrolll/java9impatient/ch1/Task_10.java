package org.demidrolll.java9impatient.ch1;

import java.util.Random;

public class Task_10 {
    public static void main(String[] args) {
        Random rand = new Random();
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            buf.append(Integer.toString(rand.nextInt(36), 36).toUpperCase());
        }
        System.out.println(buf.toString());
    }
}
