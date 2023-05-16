package com.xingray.java.container.container;

import java.util.*;
import java.util.function.Predicate;

public class ListContainer<T> implements Container<Integer, T> {

    private final List<T> list;

    public ListContainer(List<T> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException();
        }
        this.list = list;
    }

    @Override
    public T get(Integer index) {
        return list.get(index);
    }

    @Override
    public void set(Integer index, T t) {
        list.set(index, t);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public List<T> toList() {
        return new ArrayList<>(list);
    }

    @Override
    public T[] toArray() {
        T t = find(Objects::nonNull);
        if (t == null) {
            return null;
        }

        int size = list.size();
        // noinspection unchecked
        T[] array = (T[]) java.lang.reflect.Array.newInstance(t.getClass(), size);
        return list.toArray(array);
    }

    @Override
    public Map<Integer, T> toMap() {
        TreeMap<Integer, T> map = new TreeMap<>(Comparator.naturalOrder());
        for (int i = 0; i < list.size(); i++) {
            map.put(i, list.get(i));
        }
        return map;
    }

    @Override
    public Set<T> toSet() {
        return Set.copyOf(list);
    }

    @Override
    public T find(Predicate<T> predicate) {
        for (T t : list) {
            if (predicate.test(t)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public Container<Integer, T> findAll(Predicate<T> predicate) {
        List<T> result = null;
        for (T t : list) {
            if (predicate.test(t)) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(t);
            }
        }
        if (result == null) {
            return EmptyContainer.getInstance();
        }
        return new ListContainer<>(result);
    }
}
