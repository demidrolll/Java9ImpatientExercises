package org.demidrolll.java9impatient.ch3.task6;

import java.math.BigInteger;

public interface Sequence<T> {
    boolean hasNext();
    T next();
}