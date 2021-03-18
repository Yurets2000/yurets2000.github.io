package com.yube.model.mapping;

public interface BaseMapper<S, T> {
    T map(S source);

    S unmap(T source);
}
