package com.abel.tricks.recursion;

import java.util.stream.Stream;

public interface TailCall<T> {

    TailCall<T> apply();

    default boolean isDone() {
        return false;
    }

    default T getValue() {
        throw new UnsupportedOperationException();
    }

    static <T> TailCall<T> next(TailCall<T> next) {
        return next;
    }

    default T invoke() {
        return Stream.iterate(this, TailCall::apply)
                .filter(TailCall::isDone)
                .findFirst()
                .get()
                .getValue();
    }

    static <T> TailCall<T> done(final T value) {
        return new TailCall<T>() {
            @Override
            public TailCall<T> apply() {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean isDone() {
                return true;
            }

            @Override
            public T getValue() {
                return value;
            }
        };
    }

}
