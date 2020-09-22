package org.demidrolll.java9impatient.ch6.task3;

import java.util.*;

public class Table<K, V> {
    private final List<Entry<K, V>> map = new ArrayList<>();

    public V get(K key) {
        Entry<K, V> entry = new Entry<>(key, null);
        int index = map.indexOf(entry);
        return index >= 0 ? map.get(index).getValue() : null;
    }

    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value);
        int index = map.indexOf(entry);
        if (index >= 0) {
            map.set(index, entry);
        } else {
            map.add(entry);
        }
    }

    public V remove(K key) {
        Entry<K, V> entry = new Entry<>(key, null);
        int index = map.indexOf(entry);
        return index >= 0 ? map.remove(index).getValue() : null;
    }

}

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
