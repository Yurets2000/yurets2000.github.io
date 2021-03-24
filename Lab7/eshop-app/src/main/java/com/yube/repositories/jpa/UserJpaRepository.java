package com.yube.repositories.jpa;

import com.yube.model.entity.UserEntity;

import java.util.Optional;

public interface UserJpaRepository extends BaseJpaRepository<UserEntity> {
    Optional<UserEntity> findByEmail(String email);
}
