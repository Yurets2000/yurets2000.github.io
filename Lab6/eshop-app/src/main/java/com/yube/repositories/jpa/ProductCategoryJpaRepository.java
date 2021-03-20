package com.yube.repositories.jpa;

import com.yube.model.entity.ProductCategoryEntity;

import java.util.Optional;

public interface ProductCategoryJpaRepository extends BaseJpaRepository<ProductCategoryEntity> {
    Optional<ProductCategoryEntity> findFirstBy();
}
