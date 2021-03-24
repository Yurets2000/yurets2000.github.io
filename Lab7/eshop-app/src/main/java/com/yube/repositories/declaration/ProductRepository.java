package com.yube.repositories.declaration;

import com.yube.model.entity.ProductEntity;

import java.util.List;

public interface ProductRepository extends BaseRepository<ProductEntity> {
    List<ProductEntity> search(String name, int page, int pageSize);
}
