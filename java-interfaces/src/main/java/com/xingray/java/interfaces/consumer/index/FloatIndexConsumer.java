package com.xingray.java.interfaces.consumer.index;

@FunctionalInterface
public interface FloatIndexConsumer {
    void accept(float value, int index);
}
