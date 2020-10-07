package org.demidrolll.java9impatient.ch7.task13;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache<K, V> extends LinkedHashMap<K, V> {

    private final int limitSize;

    public Cache(int limitSize) {
        this.limitSize = limitSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limitSize;
    }
}
