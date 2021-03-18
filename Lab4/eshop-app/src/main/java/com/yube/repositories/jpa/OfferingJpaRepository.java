package com.yube.repositories.jpa;

import com.yube.model.entity.OfferingEntity;

import java.util.Optional;

public interface OfferingJpaRepository extends BaseJpaRepository<OfferingEntity> {
    Optional<OfferingEntity> findFirstBy();
}
