package com.yube.services;

import com.yube.model.dto.ProductComment;
import com.yube.model.entity.ProductCommentEntity;
import com.yube.model.entity.ProductEntity;
import com.yube.model.mapping.ProductCommentMapper;
import com.yube.model.mapping.utils.MappingUtils;
import com.yube.repositories.declaration.ProductCommentRepository;
import com.yube.repositories.declaration.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ProductCommentService {

    private final ProductCommentMapper productCommentMapper;
    private final ProductRepository productRepository;
    private final ProductCommentRepository productCommentRepository;

    public List<ProductComment> getAll() {
        return MappingUtils.mapAll(productCommentRepository.getAll(), productCommentMapper::map);
    }

    public ProductComment getById(String id) {
        return productCommentMapper.map(productCommentRepository.get(UUID.fromString(id)).get());
    }

    public ProductComment create(String productId, ProductComment productComment) {
        ProductCommentEntity productCommentEntity = productCommentMapper.unmap(productComment);
        ProductEntity productEntity = productRepository.get(UUID.fromString(productId)).get();
        productCommentEntity.setProduct(productEntity);
        ProductCommentEntity resultEntity = productCommentRepository.create(productCommentEntity);
        return productCommentMapper.map(resultEntity);
    }

    public ProductComment update(ProductComment productComment) {
        ProductCommentEntity sourceProductCommentEntity = productCommentMapper.unmap(productComment);
        ProductCommentEntity targetProductCommentEntity = productCommentRepository.get(sourceProductCommentEntity.getId()).get();
        BeanUtils.copyProperties(sourceProductCommentEntity, targetProductCommentEntity, "product");
        ProductCommentEntity updatedProductCategoryEntity = productCommentRepository.update(targetProductCommentEntity);
        return productCommentMapper.map(updatedProductCategoryEntity);
    }

    public void delete(String id) {
        productCommentRepository.delete(UUID.fromString(id));
    }
}
