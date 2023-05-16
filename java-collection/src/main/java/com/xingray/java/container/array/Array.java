package com.xingray.java.container.array;


import com.xingray.java.container.series.Series;

import java.util.*;
import java.util.function.Consumer;

public class Array<T> implements Iterable<T>, Series<T> {

    private final Object[] array;

    public Array(Object[] array) {
        this.array = array;
    }

    public Array(int length) {
        array = new Object[length];
    }

    @Override
    public T get(int index) {
        //noinspection unchecked
        return (T) array[index];
    }

    @Override
    public int length() {
        return array.length;
    }

    public void set(int index, T t) {
        array[index] = t;
    }

    public List<T> toList() {
        int length = length();
        if (length == 0) {
            return Collections.emptyList();
        }
        //noinspection unchecked
        return new ArrayList<T>((Collection<? extends T>) Arrays.asList(array));
    }

    public static <E> Array<E> of(Iterator<E> iterator) {
        if (iterator == null) {
            return null;
        }
        Collection<E> c;

        if (iterator instanceof Collection) {
            //noinspection unchecked
            c = (Collection<E>) iterator;
        } else {
            ArrayList<E> list = new ArrayList<>();
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
            c = list;
        }
        return new Array<>(c.toArray());
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(this);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (Object t : array) {
            //noinspection unchecked
            action.accept((T) t);
        }
    }

    private static class ArrayIterator<T> implements Iterator<T> {

        private final Array<T> array;
        private int index;

        public ArrayIterator(Array<T> array) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return array.length() > 0 && index < array.length();
        }

        @Override
        public T next() {
            T t = array.get(index);
            index++;
            return t;
        }
    }
}
