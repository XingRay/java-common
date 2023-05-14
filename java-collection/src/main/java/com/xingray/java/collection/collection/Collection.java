package com.xingray.java.collection.collection;

public interface Collection<Index, Value> {
    Value get(Index index);

    void set(Index index, Value value);

    int size();

    default boolean hasElement() {
        return size() > 0;
    }

    default boolean isEmpty() {
        return size() == 0;
    }



}
