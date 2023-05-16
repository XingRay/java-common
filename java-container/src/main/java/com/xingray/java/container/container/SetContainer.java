package com.xingray.java.container.container;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class SetContainer<T> implements Container<T, T> {

    private final Set<T> set;

    public SetContainer(Set<T> set) {
        if (set == null || set.size() == 0) {
            throw new IllegalArgumentException();
        }
        this.set = set;
    }

    @Override
    public T get(T index) {
        return set.contains(index) ? index : null;
    }

    @Override
    public void set(T index, T value) {
        set.add(value);
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public List<T> toList() {
        return List.copyOf(set);
    }

    @Override
    public T[] toArray() {
        T t = find(Objects::nonNull);
        if (t == null) {
            return null;
        }
        int size = set.size();
        // noinspection unchecked
        T[] array = (T[]) java.lang.reflect.Array.newInstance(t.getClass(), size);
        return set.toArray(array);
    }

    @Override
    public Map<T, T> toMap() {
        HashMap<T, T> map = new HashMap<>(set.size());
        for (T t : set) {
            map.put(t, t);
        }
        return map;
    }

    @Override
    public Set<T> toSet() {
        return Set.copyOf(set);
    }

    @Override
    public T find(Predicate<T> predicate) {
        for (T t : set) {
            if (predicate.test(t)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public Container<T, T> findAll(Predicate<T> predicate) {
        Set<T> result = null;
        for (T value : set) {
            if (predicate.test(value)) {
                if (result == null) {
                    result = new HashSet<>();
                }
                result.add(value);
            }
        }
        if (result == null) {
            return EmptyContainer.getInstance();
        }
        return new SetContainer<>(result);
    }

    @Override
    public Container<T, T> merge(Container<T, T> container, BiFunction<T, T, T> biConsumer) {
        if (container.isEmpty()) {
            return new SetContainer<>(set);
        }
        Set<T> target = container.toSet();
        Set<T> merged = new HashSet<>(set);
        merged.addAll(target);

        return new SetContainer<>(merged);
    }

    @Override
    public Container<T, T> copy() {
        return new SetContainer<>(set);
    }

    @Override
    public String toString() {
        return "SetContainer{" +
                "set=" + set +
                '}';
    }
}
