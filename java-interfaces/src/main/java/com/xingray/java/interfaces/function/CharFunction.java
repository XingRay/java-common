package com.xingray.java.interfaces.function;

@FunctionalInterface
public interface CharFunction<T> {
    char apply(T t);
}
