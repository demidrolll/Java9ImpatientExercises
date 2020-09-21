package org.demidrolll.java9impatient.ch6.task1;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {
    private final List<E> list = new ArrayList<>();

    public void push(E item) {
        list.add(item);
    }

    public E pop() {
        return isEmpty() ? null : list.remove(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
