package com.xingray.java.interfaces.function.index;

@FunctionalInterface
public interface DoubleIndexFunction<T> {
    double apply( T t, int index);
}
