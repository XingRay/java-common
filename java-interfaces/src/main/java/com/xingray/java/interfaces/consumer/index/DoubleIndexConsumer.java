package com.xingray.java.interfaces.consumer.index;

@FunctionalInterface
public interface DoubleIndexConsumer {
    void accept(double value, int index);
}
