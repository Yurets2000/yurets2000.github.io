package com.yube.model.mapping;

import com.yube.model.dto.Market;
import com.yube.model.entity.MarketEntity;
import org.mapstruct.Mapper;

@Mapper(uses = {StringToIdMapper.class}, componentModel = "spring")
public abstract class MarketMapper implements BaseMapper<MarketEntity, Market> {
    @Override
    public abstract Market map(MarketEntity source);

    @Override
    public abstract MarketEntity unmap(Market source);
}
