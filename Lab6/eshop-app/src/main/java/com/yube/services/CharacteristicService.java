package com.yube.services;

import com.yube.model.dto.Characteristic;
import com.yube.model.dto.ProductComment;
import com.yube.model.entity.CharacteristicEntity;
import com.yube.model.entity.CharacteristicGroupEntity;
import com.yube.model.entity.ProductCommentEntity;
import com.yube.model.entity.ProductEntity;
import com.yube.model.mapping.CharacteristicMapper;
import com.yube.model.mapping.utils.MappingUtils;
import com.yube.repositories.declaration.CharacteristicGroupRepository;
import com.yube.repositories.declaration.CharacteristicRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class CharacteristicService {

    private final CharacteristicMapper characteristicMapper;
    private final CharacteristicRepository characteristicRepository;
    private final CharacteristicGroupRepository characteristicGroupRepository;

    public List<Characteristic> getAll() {
        return MappingUtils.mapAll(characteristicRepository.getAll(), characteristicMapper::map);
    }

    public Characteristic getById(String id) {
        return characteristicMapper.map(characteristicRepository.get(UUID.fromString(id)).get());
    }

    public Characteristic create(String characteristicGroupId, Characteristic characteristic) {
        CharacteristicEntity characteristicEntity = characteristicMapper.unmap(characteristic);
        CharacteristicGroupEntity characteristicGroupEntity = characteristicGroupRepository.get(UUID.fromString(characteristicGroupId)).get();
        characteristicEntity.setGroup(characteristicGroupEntity);
        CharacteristicEntity resultEntity = characteristicRepository.create(characteristicEntity);
        return characteristicMapper.map(resultEntity);
    }

    public Characteristic update(Characteristic characteristic) {
        CharacteristicEntity sourceCharacteristicEntity = characteristicMapper.unmap(characteristic);
        CharacteristicEntity targetCharacteristicEntity = characteristicRepository.get(sourceCharacteristicEntity.getId()).get();
        BeanUtils.copyProperties(sourceCharacteristicEntity, targetCharacteristicEntity, "group", "products");
        CharacteristicEntity updatedCharacteristicEntity = characteristicRepository.update(targetCharacteristicEntity);
        return characteristicMapper.map(updatedCharacteristicEntity);
    }

    public void delete(String id) {
        characteristicRepository.delete(UUID.fromString(id));
    }
}
