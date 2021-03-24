package com.yube.model.mapping;

import com.yube.model.dto.Banner;
import com.yube.model.entity.BannerEntity;
import org.mapstruct.Mapper;

@Mapper(uses = {StringToIdMapper.class}, componentModel = "spring")
public abstract class BannerMapper implements BaseMapper<BannerEntity, Banner> {
    @Override
    public abstract Banner map(BannerEntity source);

    @Override
    public abstract BannerEntity unmap(Banner source);
}
