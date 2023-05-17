package com.xingray.java.interfaces.function.index;

@FunctionalInterface
public interface CharIndexFunction<T> {
    char apply(T t, int index);
}
