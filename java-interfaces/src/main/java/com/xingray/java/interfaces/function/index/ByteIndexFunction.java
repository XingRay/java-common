package com.xingray.java.interfaces.function.index;

@FunctionalInterface
public interface ByteIndexFunction<T> {
    byte apply(T t, int index);
}
