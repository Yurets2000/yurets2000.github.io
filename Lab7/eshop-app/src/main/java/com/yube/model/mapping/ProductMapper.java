package com.yube.model.mapping;

import com.yube.model.dto.Product;
import com.yube.model.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = {StringToIdMapper.class, CharacteristicMapper.class}, componentModel = "spring")
public abstract class ProductMapper implements BaseMapper<ProductEntity, Product> {

    @Override
    @Mappings({
            @Mapping(source = "category.id", target = "categoryId")
    })
    public abstract Product map(ProductEntity source);

    @Override
    @Mappings({
            @Mapping(source = "categoryId", target = "category.id")
    })
    public abstract ProductEntity unmap(Product source);
}
