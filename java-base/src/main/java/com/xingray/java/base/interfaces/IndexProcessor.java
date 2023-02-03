package com.xingray.java.base.interfaces;

/**
 * @author : leixing
 * description : IndexProcessor
 */
public interface IndexProcessor<T> {
    void process(int index, T t);
}