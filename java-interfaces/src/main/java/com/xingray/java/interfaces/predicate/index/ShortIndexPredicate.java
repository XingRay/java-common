package com.xingray.java.interfaces.predicate.index;

@FunctionalInterface
public interface ShortIndexPredicate {
    boolean test(short value, int index);
}
