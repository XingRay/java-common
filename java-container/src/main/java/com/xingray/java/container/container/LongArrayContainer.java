package com.xingray.java.container.container;

import com.xingray.java.container.interfaces.container.Container;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class LongArrayContainer implements Container<Integer, Long> {

    private final long[] array;

    LongArrayContainer(long[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }
        this.array = array;
    }

    @Override
    public Long get(Integer index) {
        return array[index];
    }

    @Override
    public void set(Integer index, Long value) {
        array[index] = value;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public List<Long> toList() {
        ArrayList<Long> list = new ArrayList<>(array.length);
        for (long value : array) {
            list.add(value);
        }
        return list;
    }

    @Override
    public Long[] toArray() {
        Long[] result = new Long[array.length];
        for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
            result[i] = array[i];
        }
        return result;
    }

    @Override
    public Map<Integer, Long> toMap() {
        Map<Integer, Long> map = new TreeMap<>(Comparator.naturalOrder());
        for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
            map.put(i, array[i]);
        }
        return map;
    }

    @Override
    public Set<Long> toSet() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        HashSet<Long> set = new HashSet<>();
        for (long v : array) {
            set.add(v);
        }
        return set;
    }

    @Override
    public Long find(Predicate<Long> predicate) {
        for (long v : array) {
            if (predicate.test(v)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public Container<Integer, Long> findAll(Predicate<Long> predicate) {
        List<Long> list = null;
        for (Long value : array) {
            if (predicate.test(value)) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(value);
            }
        }
        if (list == null) {
            return EmptyContainer.getInstance();
        }

        long[] array = new long[list.size()];
        for (int i = 0, listSize = list.size(); i < listSize; i++) {
            array[i] = list.get(i);
        }

        return new LongArrayContainer(array);
    }

    @Override
    public Container<Integer, Long> merge(Container<Integer, Long> container, BiFunction<Long, Long, Long> biConsumer) {
        if (container.isEmpty()) {
            return new LongArrayContainer(array);
        }
        long[] target = new long[size() + container.size()];
        System.arraycopy(array, 0, target, 0, array.length);
        Long[] containerArray = container.toArray();
        long[] mergeArray = new long[containerArray.length];
        for (int i = 0, containerArrayLength = containerArray.length; i < containerArrayLength; i++) {
            Long value = containerArray[i];
            mergeArray[i] = value;
        }
        System.arraycopy(mergeArray, 0, target, array.length, mergeArray.length);
        return new LongArrayContainer(target);
    }

    @Override
    public Container<Integer, Long> copy() {
        return new LongArrayContainer(array);
    }
}
