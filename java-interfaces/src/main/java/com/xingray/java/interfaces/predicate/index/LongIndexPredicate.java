package com.xingray.java.interfaces.predicate.index;

@FunctionalInterface
public interface LongIndexPredicate {
    boolean test(long value, int index);
}
