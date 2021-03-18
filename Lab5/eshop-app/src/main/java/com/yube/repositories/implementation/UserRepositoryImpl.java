package com.yube.repositories.implementation;

import com.yube.model.entity.UserEntity;
import com.yube.repositories.declaration.UserRepository;
import com.yube.repositories.jpa.UserJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserEntity create(UserEntity entity) {
        return userJpaRepository.save(entity);
    }

    @Override
    public UserEntity update(UserEntity entity) {
        return userJpaRepository.save(entity);
    }

    @Override
    public void delete(UserEntity entity) {
        userJpaRepository.delete(entity);
    }

    @Override
    public Optional<UserEntity> get(UUID id) {
        return userJpaRepository.findById(id);
    }

    @Override
    public List<UserEntity> getAll() {
        return userJpaRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userJpaRepository.findByEmail(email);
    }
}
