package com.yube.repositories.implementation;

import com.yube.model.entity.CharacteristicEntity;
import com.yube.repositories.declaration.CharacteristicRepository;
import com.yube.repositories.jpa.CharacteristicJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
@AllArgsConstructor
public class CharacteristicRepositoryImpl implements CharacteristicRepository {

    private final CharacteristicJpaRepository characteristicJpaRepository;

    @Override
    public CharacteristicEntity create(CharacteristicEntity entity) {
        return characteristicJpaRepository.save(entity);
    }

    @Override
    public CharacteristicEntity update(CharacteristicEntity entity) {
        return characteristicJpaRepository.save(entity);
    }

    @Override
    public void delete(CharacteristicEntity entity) {
        characteristicJpaRepository.delete(entity);
    }

    @Override
    public Optional<CharacteristicEntity> get(UUID id) {
        return characteristicJpaRepository.findById(id);
    }

    @Override
    public List<CharacteristicEntity> getAll() {
        return characteristicJpaRepository.findAll();
    }
}
