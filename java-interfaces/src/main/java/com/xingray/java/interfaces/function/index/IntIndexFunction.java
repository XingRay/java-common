package com.xingray.java.interfaces.function.index;

@FunctionalInterface
public interface IntIndexFunction<T> {
    int apply( T t, int index);
}
