package com.xingray.java.interfaces.function.index;

@FunctionalInterface
public interface LongIndexFunction<T> {
    long apply(T t, int index);
}
