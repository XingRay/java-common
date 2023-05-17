package com.xingray.java.interfaces.function.index;

@FunctionalInterface
public interface FloatIndexFunction<T> {
    float apply(T t, int index);
}
