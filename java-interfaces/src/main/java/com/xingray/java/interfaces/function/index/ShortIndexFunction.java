package com.xingray.java.interfaces.function.index;

@FunctionalInterface
public interface ShortIndexFunction<T> {
    short apply(T t, int index);
}
