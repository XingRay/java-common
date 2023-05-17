package com.xingray.java.interfaces.function;

@FunctionalInterface
public interface DoubleFunction<T> {
    double apply(T t);
}
