package com.xingray.java.interfaces.function.index;

@FunctionalInterface
public interface BooleanIndexFunction<T> {
    boolean apply(T t, int index);
}
