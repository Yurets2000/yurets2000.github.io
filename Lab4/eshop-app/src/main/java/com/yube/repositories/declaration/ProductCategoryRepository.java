package com.yube.repositories.declaration;

import com.yube.model.entity.ProductCategoryEntity;

import java.util.Optional;

public interface ProductCategoryRepository extends BaseRepository<ProductCategoryEntity> {
    Optional<ProductCategoryEntity> findFirstBy();
}
