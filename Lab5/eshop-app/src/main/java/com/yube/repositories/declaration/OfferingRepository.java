package com.yube.repositories.declaration;

import com.yube.model.entity.OfferingEntity;

import java.util.Optional;

public interface OfferingRepository extends BaseRepository<OfferingEntity> {
    Optional<OfferingEntity> findFirstBy();
}
