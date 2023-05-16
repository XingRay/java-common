package com.xingray.java.container.series;

public interface Series<T> {

    T get(int index);

    int length();
}
