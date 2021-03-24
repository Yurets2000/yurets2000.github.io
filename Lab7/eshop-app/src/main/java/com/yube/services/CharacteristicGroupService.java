package com.yube.services;

import com.yube.model.dto.CharacteristicGroup;
import com.yube.model.entity.CharacteristicGroupEntity;
import com.yube.model.mapping.CharacteristicGroupMapper;
import com.yube.model.mapping.utils.MappingUtils;
import com.yube.repositories.declaration.CharacteristicGroupRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class CharacteristicGroupService {

    private final CharacteristicGroupMapper characteristicGroupMapper;
    private final CharacteristicGroupRepository characteristicGroupRepository;

    public List<CharacteristicGroup> getAll() {
        return MappingUtils.mapAll(characteristicGroupRepository.getAll(), characteristicGroupMapper::map);
    }

    public CharacteristicGroup getById(String id) {
        return characteristicGroupMapper.map(characteristicGroupRepository.get(UUID.fromString(id)).get());
    }

    public CharacteristicGroup create(CharacteristicGroup characteristicGroup) {
        CharacteristicGroupEntity characteristicGroupEntity = characteristicGroupMapper.unmap(characteristicGroup);
        return characteristicGroupMapper.map(characteristicGroupRepository.create(characteristicGroupEntity));
    }

    public CharacteristicGroup update(CharacteristicGroup characteristicGroup) {
        CharacteristicGroupEntity sourceCharacteristicGroupEntity = characteristicGroupMapper.unmap(characteristicGroup);
        CharacteristicGroupEntity targetCharacteristicGroupEntity = characteristicGroupRepository.get(sourceCharacteristicGroupEntity.getId()).get();
        BeanUtils.copyProperties(sourceCharacteristicGroupEntity, targetCharacteristicGroupEntity, "productCategories");
        CharacteristicGroupEntity updatedCharacteristicGroupEntity = characteristicGroupRepository.update(targetCharacteristicGroupEntity);
        return characteristicGroupMapper.map(updatedCharacteristicGroupEntity);
    }

    public void delete(String id) {
        characteristicGroupRepository.delete(UUID.fromString(id));
    }
}
