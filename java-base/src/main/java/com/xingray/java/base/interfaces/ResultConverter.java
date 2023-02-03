package com.xingray.java.base.interfaces;

import com.xingray.java.base.result.Result;

public interface ResultConverter<A, B> {

    /**
     * A-> B
     */
    Result<B> to(A a);

    /**
     * B -> A
     */
    Result<A> from(B b);
}
