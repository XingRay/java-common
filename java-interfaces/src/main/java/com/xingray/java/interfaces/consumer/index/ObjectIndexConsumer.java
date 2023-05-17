package com.xingray.java.interfaces.consumer.index;

@FunctionalInterface
public interface ObjectIndexConsumer<T> {
    void accept(T value, int index);
}
