package com.xingray.java.container.container;

import java.util.*;
import java.util.function.Predicate;

public final class ArrayContainer<T> implements Container<Integer, T> {

    private final T[] array;
    private Class<T> cls;

    ArrayContainer(T[] array, Class<T> cls) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }
        if (cls == null) {
            throw new IllegalArgumentException();
        }
        this.array = array;
        this.cls = cls;
    }

    @Override
    public T get(Integer index) {
        return array[index];
    }

    @Override
    public void set(Integer index, T t) {
        array[index] = t;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public List<T> toList() {
        return new ArrayList<>(Arrays.asList(array));
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(array, array.length);
    }

    @Override
    public Map<Integer, T> toMap() {
        HashMap<Integer, T> map = new HashMap<>(array.length);
        for (int i = 0; i < array.length; i++) {
            map.put(i, array[i]);
        }
        return map;
    }

    @Override
    public Set<T> toSet() {
        return new HashSet<>(Arrays.asList(array));
    }

    @Override
    public T find(Predicate<T> predicate) {
        for (T t : array) {
            if (predicate.test(t)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public Container<Integer, T> findAll(Predicate<T> predicate) {
        List<T> list = null;
        for (T t : array) {
            if (predicate.test(t)) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(t);
            }
        }
        if (list == null) {
            return EmptyContainer.getInstance();
        }
        // noinspection unchecked
        T[] array = (T[]) java.lang.reflect.Array.newInstance(cls, list.size());
        return new ArrayContainer<>(list.toArray(array), cls);
    }
}
