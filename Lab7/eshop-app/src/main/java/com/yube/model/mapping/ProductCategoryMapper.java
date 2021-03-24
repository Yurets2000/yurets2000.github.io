package com.yube.model.mapping;

import com.yube.model.dto.ProductCategory;
import com.yube.model.entity.ProductCategoryEntity;
import org.mapstruct.Mapper;

@Mapper(uses = {StringToIdMapper.class, ProductMapper.class, CharacteristicGroupMapper.class}, componentModel = "spring")
public abstract class ProductCategoryMapper implements BaseMapper<ProductCategoryEntity, ProductCategory> {

    @Override
    public abstract ProductCategory map(ProductCategoryEntity source);

    @Override
    public abstract ProductCategoryEntity unmap(ProductCategory source);
}
