package com.yube.model.mapping;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StringToIdMapper {

    public UUID stringToId(String value) {
        return value != null && !value.isEmpty() ? UUID.fromString(value) : null;
    }

    public String idToString(UUID value) {
        return value != null ? String.valueOf(value) : null;
    }
}
