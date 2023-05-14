package com.xingray.java.collection.collection;

import java.util.Set;

public class SetCollection<T> implements Collection<Void, T> {

    private final Set<T> set;

    public SetCollection(Set<T> set) {
        this.set = set;
    }

    @Override
    public T get(Void unused) {
        return null;
    }

    @Override
    public void set(Void index, T value) {
        set.add(value);
    }

    @Override
    public int size() {
        return set.size();
    }
}
