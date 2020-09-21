package org.demidrolll.java9impatient.ch6.task2;

import java.util.Arrays;

public class ObjectStack<E> {
    private Object[] list;
    private int size;

    public ObjectStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("stack capacity is zero");
        }
        this.list = new Object[capacity];
    }

    public void push(E item) {
        if (size == list.length) {
            list = Arrays.copyOf(list, list.length * 2);
        }
        size++;
        list[size - 1] = item;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (size > 0) {
            E item = (E) list[size - 1];
            list[size - 1] = null;
            size--;
            return item;
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
