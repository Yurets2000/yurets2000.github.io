package com.yube.model.mapping;

import com.yube.model.dto.Offering;
import com.yube.model.entity.OfferingEntity;
import org.mapstruct.Mapper;

@Mapper(uses = {StringToIdMapper.class, ProductMapper.class}, componentModel = "spring")
public abstract class OfferingMapper implements BaseMapper<OfferingEntity, Offering> {

    @Override
    public abstract Offering map(OfferingEntity source);

    @Override
    public abstract OfferingEntity unmap(Offering source);
}
