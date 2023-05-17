package com.xingray.java.interfaces.predicate.index;

@FunctionalInterface
public interface DoubleIndexPredicate {
    boolean test(double value, int index);
}
