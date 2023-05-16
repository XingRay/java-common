package com.xingray.java.container.container;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public final class DoubleArrayContainer implements Container<Integer, Double> {

    private final double[] array;

    DoubleArrayContainer(double[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }
        this.array = array;
    }

    @Override
    public Double get(Integer index) {
        return array[index];
    }

    @Override
    public void set(Integer index, Double value) {
        array[index] = value;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public List<Double> toList() {
        ArrayList<Double> list = new ArrayList<>(array.length);
        for (Double value : array) {
            list.add(value);
        }
        return list;
    }

    @Override
    public Double[] toArray() {
        Double[] result = new Double[array.length];
        for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
            result[i] = array[i];
        }
        return result;
    }

    @Override
    public Map<Integer, Double> toMap() {
        Map<Integer, Double> map = new TreeMap<>(Comparator.naturalOrder());
        for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
            map.put(i, array[i]);
        }
        return map;
    }

    @Override
    public Set<Double> toSet() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        HashSet<Double> set = new HashSet<>();
        for (double v : array) {
            set.add(v);
        }
        return set;
    }

    @Override
    public Double find(Predicate<Double> predicate) {
        for (double v : array) {
            if (predicate.test(v)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public Container<Integer, Double> findAll(Predicate<Double> predicate) {
        List<Double> list = null;
        for (Double value : array) {
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

        double[] array = new double[list.size()];
        for (int i = 0, listSize = list.size(); i < listSize; i++) {
            array[i] = list.get(i);
        }

        return new DoubleArrayContainer(array);
    }

    @Override
    public Container<Integer, Double> merge(Container<Integer, Double> container, BiFunction<Double, Double, Double> biConsumer) {
        if (container.isEmpty()) {
            return new DoubleArrayContainer(array);
        }
        double[] target = new double[size() + container.size()];
        System.arraycopy(array, 0, target, 0, array.length);
        Double[] containerArray = container.toArray();
        double[] mergeArray = new double[containerArray.length];
        for (int i = 0, containerArrayLength = containerArray.length; i < containerArrayLength; i++) {
            Double value = containerArray[i];
            mergeArray[i] = value;
        }
        System.arraycopy(mergeArray, 0, target, array.length, mergeArray.length);
        return new DoubleArrayContainer(target);
    }

    @Override
    public Container<Integer, Double> copy() {
        return new DoubleArrayContainer(array);
    }
}
