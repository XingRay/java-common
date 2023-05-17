package com.xingray.java.interfaces.predicate.index;

@FunctionalInterface
public interface BooleanIndexPredicate {
    boolean test(boolean value, int index);
}
