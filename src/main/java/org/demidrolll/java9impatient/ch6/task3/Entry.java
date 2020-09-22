package org.demidrolll.java9impatient.ch6.task3;

import java.util.Objects;

class Entry<K, V> {
    private final K key;
    private final V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked")
        Entry<K, V> other = (Entry<K, V>) o;
        return Objects.equals(this.getKey(), other.getKey());
    }
}
