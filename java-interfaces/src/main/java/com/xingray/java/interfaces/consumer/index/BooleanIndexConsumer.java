package com.xingray.java.interfaces.consumer.index;

@FunctionalInterface
public interface BooleanIndexConsumer {
    void accept(boolean value, int index);
}
