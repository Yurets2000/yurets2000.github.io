package com.yube.repositories.implementation;

import com.yube.model.entity.ProductCategoryEntity;
import com.yube.repositories.declaration.ProductCategoryRepository;
import com.yube.repositories.jpa.ProductCategoryJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
@AllArgsConstructor
public class ProductCategoryRepositoryImpl implements ProductCategoryRepository {

    private final ProductCategoryJpaRepository productCategoryJpaRepository;

    @Override
    public ProductCategoryEntity create(ProductCategoryEntity entity) {
        return productCategoryJpaRepository.save(entity);
    }

    @Override
    public ProductCategoryEntity update(ProductCategoryEntity entity) {
        return productCategoryJpaRepository.save(entity);
    }

    @Override
    public void delete(ProductCategoryEntity entity) {
        productCategoryJpaRepository.delete(entity);
    }

    @Override
    public Optional<ProductCategoryEntity> get(UUID id) {
        return productCategoryJpaRepository.findById(id);
    }

    @Override
    public List<ProductCategoryEntity> getAll() {
        return productCategoryJpaRepository.findAll();
    }

    @Override
    public Optional<ProductCategoryEntity> findFirstBy() {
        return productCategoryJpaRepository.findFirstBy();
    }
}
