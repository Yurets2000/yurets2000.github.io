package com.yube.model.mapping;

import com.yube.model.dto.CharacteristicGroup;
import com.yube.model.entity.CharacteristicGroupEntity;
import org.mapstruct.Mapper;

@Mapper(uses = {StringToIdMapper.class, CharacteristicMapper.class}, componentModel = "spring")
public abstract class CharacteristicGroupMapper implements BaseMapper<CharacteristicGroupEntity, CharacteristicGroup> {

    @Override
    public abstract CharacteristicGroup map(CharacteristicGroupEntity source);

    @Override
    public abstract CharacteristicGroupEntity unmap(CharacteristicGroup source);
}
