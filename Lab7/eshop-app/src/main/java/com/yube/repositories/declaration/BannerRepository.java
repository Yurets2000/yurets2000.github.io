package com.yube.repositories.declaration;

import com.yube.model.entity.BannerEntity;

public interface BannerRepository extends BaseRepository<BannerEntity> {
    BannerEntity getRandom();
}
