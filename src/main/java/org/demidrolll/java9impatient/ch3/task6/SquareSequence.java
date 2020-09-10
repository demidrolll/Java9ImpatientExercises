package org.demidrolll.java9impatient.ch3.task6;

import java.math.BigInteger;

public class SquareSequence implements Sequence<BigInteger> {
    private int i = 0;

    public boolean hasNext() {
        return true;
    }

    public BigInteger next() {
        i++;
        return BigInteger.valueOf(i * i);
    }
}