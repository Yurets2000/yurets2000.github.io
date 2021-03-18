package com.yube.repositories.implementation;

import com.yube.model.entity.ProductEntity;
import com.yube.repositories.declaration.ProductRepository;
import com.yube.repositories.jpa.ProductJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
@AllArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public ProductEntity create(ProductEntity entity) {
        return productJpaRepository.save(entity);
    }

    @Override
    public ProductEntity update(ProductEntity entity) {
        return productJpaRepository.save(entity);
    }

    @Override
    public void delete(ProductEntity entity) {
        productJpaRepository.delete(entity);
    }

    @Override
    public Optional<ProductEntity> get(UUID id) {
        return productJpaRepository.findById(id);
    }

    @Override
    public List<ProductEntity> getAll() {
        return productJpaRepository.findAll();
    }
}
