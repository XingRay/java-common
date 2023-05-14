package com.xingray.java.collection.collection;

import java.util.List;

public class ListCollection<T> implements Collection<Integer, T> {

    private final List<T> list;

    public ListCollection(List<T> list) {
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
}
