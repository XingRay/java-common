package com.xingray.java.container.container;

import com.xingray.java.container.interfaces.container.Container;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public final class EmptyContainer<Index, Value> implements Container<Index, Value> {

    private static final EmptyContainer<Object, Object> INSTANCE = new EmptyContainer<>();

    public static <K, V> EmptyContainer<K, V> getInstance() {
        // noinspection unchecked
        return (EmptyContainer<K, V>) INSTANCE;
    }

    private EmptyContainer() {
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

    @Override
    public List<Value> toList() {
        return Collections.emptyList();
    }

    @Override
    public Value[] toArray() {
        throw new UnsupportedOperationException("consider to use ");
    }

    @Override
    public Map<Index, Value> toMap() {
        return Collections.emptyMap();
    }

    @Override
    public Set<Value> toSet() {
        return Collections.emptySet();
    }

    @Override
    public Value find(Predicate<Value> predicate) {
        return null;
    }

    @Override
    public Container<Index, Value> findAll(Predicate<Value> predicate) {
        //noinspection unchecked
        return this;
    }

    @Override
    public Container<Index, Value> merge(Container<Index, Value> container, BiFunction<Value, Value, Value> biConsumer) {
        return container.copy();
    }

    @Override
    public Container<Index, Value> copy() {
        return this;
    }
}
