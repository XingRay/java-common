package com.xingray.java.interfaces.function.index;

@FunctionalInterface
public interface ObjectIndexFunction<T, R> {
    R apply(T t, int index);
}
