package org.demidrolll.java9impatient.ch1;

import java.math.BigInteger;

public class Task_4 {

    public static void main(String[] args) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= 20; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        System.out.println("factorial: " + fact.toString());
    }
}
