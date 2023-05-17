package com.xingray.java.container.array;



import com.xingray.java.container.interfaces.series.IntSeries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class IntArray implements Iterable<Integer>, IntSeries {

    private final int[] array;

    public IntArray(int[] array) {
        this.array = array;
    }

    public IntArray(int length) {
        array = new int[length];
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public int length() {
        return array.length;
    }

    public void set(int index, int value) {
        array[index] = value;
    }

    public List<Integer> toList() {
        int length = length();
        if (length == 0) {
            return Collections.emptyList();
        }
        ArrayList<Integer> list = new ArrayList<>(length);
        for (int value : array) {
            list.add(value);
        }
        return list;
    }

    public static IntArray of(int... values) {
        if (values == null) {
            return null;
        }
        return new IntArray(values);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ArrayIterator(this);
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int value : array) {
            action.accept(value);
        }
    }

    private static class ArrayIterator implements Iterator<Integer> {

        private final IntArray array;
        private int index;

        public ArrayIterator(IntArray array) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return array.length() > 0 && index < array.length();
        }

        @Override
        public Integer next() {
            int value = array.get(index);
            index++;
            return value;
        }
    }
}
