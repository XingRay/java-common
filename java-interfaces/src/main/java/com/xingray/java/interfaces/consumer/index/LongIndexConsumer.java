package com.xingray.java.interfaces.consumer.index;

@FunctionalInterface
public interface LongIndexConsumer {
    void accept(long value, int index);
}
