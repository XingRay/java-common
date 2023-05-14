package com.xingray.java.collection.collection;

import java.util.Map;

public class MapCollection<K, V> implements Collection<K, V>{
    private final Map<K, V> map;

    public MapCollection(Map<K, V>map) {
        this.map = map;
    }

    @Override
    public V get(K k) {
        return map.get(k);
    }

    @Override
    public void set(K k, V v) {
        map.put(k, v);
    }

    @Override
    public int size() {
        return map.size();
    }
}
