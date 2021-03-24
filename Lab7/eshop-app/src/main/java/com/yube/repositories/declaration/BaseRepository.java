package com.yube.repositories.declaration;

import com.yube.model.entity.BaseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseRepository<T extends BaseEntity> {
    T create(T entity);

    T update(T entity);

    void delete(T entity);

    default void delete(UUID id) {
        delete(get(id).get());
    }

    Optional<T> get(UUID id);

    List<T> getAll();
}
