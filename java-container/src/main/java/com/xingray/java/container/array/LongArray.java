package com.xingray.java.container.array;


import com.xingray.java.container.series.LongSeries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class LongArray implements Iterable<Long>, LongSeries {

    private final long[] array;

    public LongArray(long[] array) {
        this.array = array;
    }

    public LongArray(int length) {
        array = new long[length];
    }

    @Override
    public long get(int index) {
        return array[index];
    }

    @Override
    public int length() {
        return array.length;
    }

    public void set(int index, long value) {
        array[index] = value;
    }

    public List<Long> toList() {
        int length = length();
        if (length == 0) {
            return Collections.emptyList();
        }
        ArrayList<Long> list = new ArrayList<>(length);
        for (long value : array) {
            list.add(value);
        }
        return list;
    }

    public static LongArray of(long... values) {
        if (values == null) {
            return null;
        }
        return new LongArray(values);
    }

    @Override
    public Iterator<Long> iterator() {
        return new ArrayIterator(this);
    }

    @Override
    public void forEach(Consumer<? super Long> action) {
        if (array == null || array.length == 0) {
            return;
        }
        for (long value : array) {
            action.accept(value);
        }
    }

    private static class ArrayIterator implements Iterator<Long> {

        private final LongArray array;
        private int index;

        public ArrayIterator(LongArray array) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return array.length() > 0 && index < array.length();
        }

        @Override
        public Long next() {
            long value = array.get(index);
            index++;
            return value;
        }
    }
}
