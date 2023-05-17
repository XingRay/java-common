package com.xingray.java.container.container;

import com.xingray.java.container.interfaces.container.Container;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class IteratableContainer<T> implements Container<Integer, T> {

    private final Iterable<T> iterable;

    public IteratableContainer(Iterable<T> iterable) {
        if (iterable == null || isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.iterable = iterable;
    }

    @Override
    public boolean hasElement() {
        return iterable.iterator().hasNext();
    }

    @Override
    public boolean isEmpty() {
        return !iterable.iterator().hasNext();
    }

    @Override
    public T get(Integer index) {
//        return iterable.get(index);
        return null;
    }

    @Override
    public void set(Integer index, T t) {
//        iterable.set(index, t);
    }

    @Override
    public int size() {
//        return iterable.size();
        return 0;
    }

    @Override
    public List<T> toList() {
//        return new ArrayList<>(iterable);
        return null;
    }

    @Override
    public T[] toArray() {
//        T t = find(Objects::nonNull);
//        if (t == null) {
//            return null;
//        }
//
//        int size = iterable.size();
//        // noinspection unchecked
//        T[] array = (T[]) java.lang.reflect.Array.newInstance(t.getClass(), size);
//        return iterable.toArray(array);
        return null;
    }

    @Override
    public Map<Integer, T> toMap() {
//        TreeMap<Integer, T> map = new TreeMap<>(Comparator.naturalOrder());
//        for (int i = 0; i < iterable.size(); i++) {
//            map.put(i, iterable.get(i));
//        }
//        return map;
        return null;
    }

    @Override
    public Set<T> toSet() {
//        return Set.copyOf(iterable);
        return null;
    }

    @Override
    public T find(Predicate<T> predicate) {
        for (T t : iterable) {
            if (predicate.test(t)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public Container<Integer, T> findAll(Predicate<T> predicate) {
        List<T> result = null;
        for (T t : iterable) {
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
        return new IteratableContainer<>(result);
    }

    @Override
    public Container<Integer, T> merge(Container<Integer, T> container, BiFunction<T, T, T> biConsumer) {
//        if (container.isEmpty()) {
//            return new IteratableContainer<>(iterable);
//        }
//        List<T> target = container.toList();
//
//        List<T> merged = new ArrayList<>(iterable.size() + target.size());
//        merged.addAll(iterable);
//        merged.addAll(target);
//        return new IteratableContainer<>(merged);
        return null;
    }

    @Override
    public Container<Integer, T> copy() {
        return new IteratableContainer<>(iterable);
    }

    @Override
    public String toString() {
        return "ListContainer{" +
                "list=" + iterable +
                '}';
    }
}
