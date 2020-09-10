package org.demidrolll.java9impatient.ch3.task7;

import java.util.Iterator;

public class DigitSequence implements Iterator<Integer> {
    private int number;

    public DigitSequence(int n) {
        number = n;
    }

    public boolean hasNext() {
        return number != 0;
    }

    public Integer next() {
        int result = number % 10;
        number /= 10;
        return result;
    }
    
    public int rest() {
        return number;
    }

    public void remove() {
    }
}