package com.xingray.java.interfaces.function;

@FunctionalInterface
public interface IntFunction<T> {
    int apply(T t);
}
