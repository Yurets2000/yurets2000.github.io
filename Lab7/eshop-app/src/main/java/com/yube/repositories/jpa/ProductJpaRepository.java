package com.yube.repositories.jpa;

import com.yube.model.entity.ProductEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductJpaRepository extends BaseJpaRepository<ProductEntity> {
    List<ProductEntity> findAllByNameContains(String name, Pageable pageable);
}
