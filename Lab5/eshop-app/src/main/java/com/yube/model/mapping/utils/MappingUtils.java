package com.yube.model.mapping.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MappingUtils {
    public static <T, S> List<T> mapAll(List<S> source, Function<? super S, ? extends T> mapper) {
        return source.stream().map(mapper).collect(Collectors.toList());
    }
}
