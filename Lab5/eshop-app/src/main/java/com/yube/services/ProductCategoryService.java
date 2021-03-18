package com.yube.services;

import com.yube.model.dto.ProductCategory;
import com.yube.model.entity.ProductCategoryEntity;
import com.yube.model.mapping.ProductCategoryMapper;
import com.yube.model.mapping.utils.MappingUtils;
import com.yube.repositories.declaration.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ProductCategoryService {

    private final ProductCategoryMapper productCategoryMapper;
    private final ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> getAll() {
        return MappingUtils.mapAll(productCategoryRepository.getAll(), productCategoryMapper::map);
    }

    public ProductCategory getById(String id) {
        return productCategoryMapper.map(productCategoryRepository.get(UUID.fromString(id)).get());
    }

    public ProductCategory getDefault() {
        return productCategoryMapper.map(productCategoryRepository.findFirstBy().orElse(null));
    }

    public ProductCategory create(ProductCategory productCategory) {
        ProductCategoryEntity productCategoryEntity = productCategoryMapper.unmap(productCategory);
        return productCategoryMapper.map(productCategoryRepository.create(productCategoryEntity));
    }

    public ProductCategory update(ProductCategory productCategory) {
        ProductCategoryEntity sourceProductCategoryEntity = productCategoryMapper.unmap(productCategory);
        ProductCategoryEntity targetProductCategoryEntity = productCategoryRepository.get(sourceProductCategoryEntity.getId()).get();
        BeanUtils.copyProperties(sourceProductCategoryEntity, targetProductCategoryEntity);
        ProductCategoryEntity updatedProductCategoryEntity = productCategoryRepository.update(targetProductCategoryEntity);
        return productCategoryMapper.map(updatedProductCategoryEntity);
    }

    public void delete(String id) {
        productCategoryRepository.delete(UUID.fromString(id));
    }
}
