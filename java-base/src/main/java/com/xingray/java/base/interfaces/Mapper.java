package com.xingray.java.base.interfaces;

public interface Mapper<T, R> {
    R map(T t);
}