package com.xingray.java.interfaces.predicate.index;

@FunctionalInterface
public interface ByteIndexPredicate {
    boolean test(byte value, int index);
}
