package com.xingray.java.interfaces.function;

@FunctionalInterface
public interface LongFunction<T> {
    long apply(T t);
}
