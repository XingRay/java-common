package com.xingray.java.base.interfaces;

/**
 * 带下标的映射器，通常用于循环
 *
 * @author : leixing
 */
public interface IndexMapper<T, R> {
    R map(int index, T t);
}
