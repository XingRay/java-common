package com.xingray.java.container.container;

import com.xingray.java.container.interfaces.container.Container;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class MapContainer<K, V> implements Container<K, V> {
    private final Map<K, V> map;

    public MapContainer(Map<K, V> map) {
        if (map == null || map.size() == 0) {
            throw new IllegalArgumentException();
        }
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

    @Override
    public List<V> toList() {
        return new ArrayList<>(map.values());
    }

    @Override
    public V[] toArray() {
        V t = find(Objects::nonNull);
        if (t == null) {
            return null;
        }

        int size = map.size();
        // noinspection unchecked
        V[] array = (V[]) java.lang.reflect.Array.newInstance(t.getClass(), size);
        return map.values().toArray(array);
    }

    @Override
    public Map<K, V> toMap() {
        return Map.copyOf(map);
    }

    @Override
    public Set<V> toSet() {
        return Set.copyOf(map.values());
    }

    @Override
    public V find(Predicate<V> predicate) {
        Set<Map.Entry<K, V>> entries = map.entrySet();
        for (Map.Entry<K, V> entry : entries) {
            V value = entry.getValue();
            if (predicate.test(value)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public Container<K, V> findAll(Predicate<V> predicate) {
        Map<K, V> result = null;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();
            if (predicate.test(value)) {
                if (result == null) {
                    result = new HashMap<>();
                }
                result.put(key, value);
            }
        }
        if (result == null) {
            return EmptyContainer.getInstance();
        }
        return new MapContainer<>(result);
    }

    @Override
    public Container<K, V> merge(Container<K, V> container, BiFunction<V, V, V> biConsumer) {
        if (container.isEmpty()) {
            return new MapContainer<>(map);
        }
        HashMap<K, V> merged = new HashMap<>(map);
        Map<K, V> target = container.toMap();
        for (Map.Entry<K, V> entry : target.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            V mergedValue = merged.get(key);
            if (mergedValue == null) {
                merged.put(key, value);
            } else {
                merged.put(key, biConsumer.apply(mergedValue, value));
            }
        }
        return new MapContainer<>(merged);
    }

    @Override
    public Container<K, V> copy() {
        return new MapContainer<>(map);
    }

    @Override
    public String toString() {
        return "MapContainer{" +
                "map=" + map +
                '}';
    }
}
