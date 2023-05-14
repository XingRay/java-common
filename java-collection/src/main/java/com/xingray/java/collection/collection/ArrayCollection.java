package com.xingray.java.collection.collection;

public class ArrayCollection<T> implements Collection<Integer, T> {

    private final T[] array;

    public ArrayCollection(T[] array) {
        this.array = array;
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
}
