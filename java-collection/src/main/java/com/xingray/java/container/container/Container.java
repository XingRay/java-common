package com.xingray.java.container.container;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public interface Container<Index, Value> {
    Value get(Index index);

    void set(Index index, Value value);

    int size();

    default boolean hasElement() {
        return size() > 0;
    }

    default boolean isEmpty() {
        return size() == 0;
    }

    List<Value> toList();

    Value[] toArray();

    Map<Index, Value> toMap();

    Set<Value> toSet();

    Value find(Predicate<Value> predicate);

    Container<Index, Value> findAll(Predicate<Value> predicate);


}
