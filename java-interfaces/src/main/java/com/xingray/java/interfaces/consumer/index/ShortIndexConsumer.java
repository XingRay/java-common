package com.xingray.java.interfaces.consumer.index;

@FunctionalInterface
public interface ShortIndexConsumer {
    void accept(short value, int index);
}
