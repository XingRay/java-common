package com.xingray.java.interfaces.predicate.index;

@FunctionalInterface
public interface ObjectIndexPredicate<T> {
    boolean test(T value, int index);
}
