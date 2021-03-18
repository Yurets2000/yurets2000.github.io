package com.yube.model.mapping;

import com.yube.model.dto.Characteristic;
import com.yube.model.entity.CharacteristicEntity;
import org.mapstruct.Mapper;

@Mapper(uses = {StringToIdMapper.class}, componentModel = "spring")
public abstract class CharacteristicMapper implements BaseMapper<CharacteristicEntity, Characteristic> {

    @Override
    public abstract Characteristic map(CharacteristicEntity source);

    @Override
    public abstract CharacteristicEntity unmap(Characteristic source);
}
