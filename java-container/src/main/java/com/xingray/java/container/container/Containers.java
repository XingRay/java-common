package com.xingray.java.container.container;

import com.xingray.java.container.interfaces.container.Container;

import java.util.List;
import java.util.Map;

public class Containers {

    public static <K, V> Container<K, V> of(Map<K, V> map) {
        if (map == null || map.size() == 0) {
            return empty();
        }
        return new MapContainer<>(map);
    }

    public static <T> Container<Integer, T> of(List<T> list) {
        if (list == null || list.size() == 0) {
            return empty();
        }
        return new ListContainer<>(list);
    }

    public static <T> Container<Integer, T> of(T[] array) {
        if (array == null || array.length == 0) {
            return empty();
        }
        Class<T> cls = findClass(array);
        if (cls == null) {
            throw new IllegalArgumentException();
        }
        return of(cls, array);
    }

    public static <T> Container<Integer, T> of(Class<T> cls, T[] array) {
        if (array == null || array.length == 0) {
            return empty();
        }
        return new ArrayContainer<>(array, cls);
    }

    public static <T> Container<Integer, T> ofValues(T... values) {
        if (values == null || values.length == 0) {
            return empty();
        }
        Class<T> cls = findClass(values);
        if (cls == null) {
            throw new IllegalArgumentException();
        }
        return ofValues(cls, values);
    }

    public static <T> Container<Integer, T> ofValues(Class<T> cls, T... values) {
        if (values == null || values.length == 0) {
            return empty();
        }
        return new ArrayContainer<>(values, cls);
    }

    public static <K, V> Container<K, V> empty() {
        return EmptyContainer.getInstance();
    }

    public static <T> Class<T> findClass(T[] array) {
        for (T t : array) {
            if (t != null) {
                // noinspection unchecked
                return (Class<T>) t.getClass();
            }
        }
        return null;
    }
}
