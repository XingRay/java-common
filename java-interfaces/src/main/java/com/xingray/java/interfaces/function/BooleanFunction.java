package com.xingray.java.interfaces.function;

@FunctionalInterface
public interface BooleanFunction<T> {
    boolean apply(T t);
}
