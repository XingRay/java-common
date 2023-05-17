package com.xingray.java.interfaces.consumer.index;

@FunctionalInterface
public interface ByteIndexConsumer {
    void accept(byte value, int index);
}
