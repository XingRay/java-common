package com.xingray.java.interfaces.function;

@FunctionalInterface
public interface ByteFunction<T> {
    byte apply(T t);
}
