package com.yube.repositories.declaration;

import com.yube.model.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends BaseRepository<UserEntity> {
    Optional<UserEntity> findByEmail(String email);
}
