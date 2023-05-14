package com.xingray.java.collection.collection;

public class NullCollection<Index, Value> implements Collection<Index, Value>{

    public NullCollection() {
    }

    @Override
    public Value get(Index index) {
        return null;
    }

    @Override
    public void set(Index index, Value value) {

    }

    @Override
    public int size() {
        return 0;
    }
}
