package com.yube.model.mapping;

import com.yube.model.dto.Characteristic;
import com.yube.model.entity.CharacteristicEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = {StringToIdMapper.class}, componentModel = "spring")
public abstract class CharacteristicMapper implements BaseMapper<CharacteristicEntity, Characteristic> {

    @Override
    @Mappings({
            @Mapping(source = "group.id", target = "groupId")
    })
    public abstract Characteristic map(CharacteristicEntity source);

    @Override
    @Mappings({
            @Mapping(source = "groupId", target = "group.id")
    })
    public abstract CharacteristicEntity unmap(Characteristic source);
}
