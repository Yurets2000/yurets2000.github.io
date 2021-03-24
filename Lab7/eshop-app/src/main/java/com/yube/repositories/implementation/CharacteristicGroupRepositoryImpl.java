package com.yube.repositories.implementation;

import com.yube.model.entity.CharacteristicGroupEntity;
import com.yube.repositories.declaration.CharacteristicGroupRepository;
import com.yube.repositories.jpa.CharacteristicGroupJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
@AllArgsConstructor
public class CharacteristicGroupRepositoryImpl implements CharacteristicGroupRepository {

    private final CharacteristicGroupJpaRepository characteristicGroupJpaRepository;

    @Override
    public CharacteristicGroupEntity create(CharacteristicGroupEntity entity) {
        return characteristicGroupJpaRepository.save(entity);
    }

    @Override
    public CharacteristicGroupEntity update(CharacteristicGroupEntity entity) {
        return characteristicGroupJpaRepository.save(entity);
    }

    @Override
    public void delete(CharacteristicGroupEntity entity) {
        characteristicGroupJpaRepository.delete(entity);
    }

    @Override
    public Optional<CharacteristicGroupEntity> get(UUID id) {
        return characteristicGroupJpaRepository.findById(id);
    }

    @Override
    public List<CharacteristicGroupEntity> getAll() {
        return characteristicGroupJpaRepository.findAll();
    }
}
