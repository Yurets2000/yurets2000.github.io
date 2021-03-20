package com.yube.model.mapping;

import com.yube.model.dto.ProductComment;
import com.yube.model.entity.ProductCommentEntity;
import org.mapstruct.Mapper;

@Mapper(uses = {StringToIdMapper.class}, componentModel = "spring")
public abstract class ProductCommentMapper implements BaseMapper<ProductCommentEntity, ProductComment> {

    @Override
    public abstract ProductComment map(ProductCommentEntity source);

    @Override
    public abstract ProductCommentEntity unmap(ProductComment source);
}
