package com.xingray.java.container.array;


import com.xingray.java.container.series.DoubleSeries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class DoubleArray implements Iterable<Double>, DoubleSeries {

    private final double[] array;

    public DoubleArray(double[] array) {
        this.array = array;
    }

    public DoubleArray(int length) {
        array = new double[length];
    }

    @Override
    public double get(int index) {
        return array[index];
    }

    @Override
    public int length() {
        return array.length;
    }

    public void set(int index, double value) {
        array[index] = value;
    }

    public List<Double> toList() {
        int length = length();
        if (length == 0) {
            return Collections.emptyList();
        }
        ArrayList<Double> list = new ArrayList<>(length);
        for (double value : array) {
            list.add(value);
        }
        return list;
    }

    public static DoubleArray of(double... values) {
        if (values == null) {
            return null;
        }
        return new DoubleArray(values);
    }

    @Override
    public Iterator<Double> iterator() {
        return new ArrayIterator(this);
    }

    @Override
    public void forEach(Consumer<? super Double> action) {
        if (array == null || array.length == 0) {
            return;
        }
        for (double value : array) {
            action.accept(value);
        }
    }

    private static class ArrayIterator implements Iterator<Double> {

        private final DoubleArray array;
        private int index;

        public ArrayIterator(DoubleArray array) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return array.length() > 0 && index < array.length();
        }

        @Override
        public Double next() {
            double value = array.get(index);
            index++;
            return value;
        }
    }
}
