package com.yube.services;

import com.yube.model.dto.Product;
import com.yube.model.entity.ProductCategoryEntity;
import com.yube.model.entity.ProductCommentEntity;
import com.yube.model.entity.ProductEntity;
import com.yube.model.mapping.ProductMapper;
import com.yube.model.mapping.utils.MappingUtils;
import com.yube.repositories.declaration.ProductCategoryRepository;
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
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    public List<Product> getAll() {
        return MappingUtils.mapAll(productRepository.getAll(), productMapper::map);
    }

    public Product getById(String id) {
        return productMapper.map(productRepository.get(UUID.fromString(id)).get());
    }

    public Product create(String productCategoryId, Product product) {
        ProductEntity productEntity = productMapper.unmap(product);
        ProductCategoryEntity productCategoryEntity = productCategoryRepository.get(UUID.fromString(productCategoryId)).get();
        productEntity.setCategory(productCategoryEntity);
        ProductEntity resultEntity = productRepository.create(productEntity);
        return productMapper.map(resultEntity);
    }

    public Product update(Product product) {
        ProductEntity sourceProductEntity = productMapper.unmap(product);
        ProductEntity targetProductEntity = productRepository.get(sourceProductEntity.getId()).get();
        BeanUtils.copyProperties(sourceProductEntity, targetProductEntity, "category", "offerings");
        ProductEntity updatedProductEntity = productRepository.update(targetProductEntity);
        return productMapper.map(updatedProductEntity);
    }

    public void delete(String id) {
        productRepository.delete(UUID.fromString(id));
    }
}
