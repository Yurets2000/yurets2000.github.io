package com.yube.repositories.implementation;

import com.yube.model.entity.ProductCommentEntity;
import com.yube.repositories.declaration.ProductCommentRepository;
import com.yube.repositories.jpa.ProductCommentJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
@AllArgsConstructor
public class ProductCommentRepositoryImpl implements ProductCommentRepository {

    private final ProductCommentJpaRepository productCommentJpaRepository;

    @Override
    public ProductCommentEntity create(ProductCommentEntity entity) {
        return productCommentJpaRepository.save(entity);
    }

    @Override
    public ProductCommentEntity update(ProductCommentEntity entity) {
        return productCommentJpaRepository.save(entity);
    }

    @Override
    public void delete(ProductCommentEntity entity) {
        productCommentJpaRepository.delete(entity);
    }

    @Override
    public Optional<ProductCommentEntity> get(UUID id) {
        return productCommentJpaRepository.findById(id);
    }

    @Override
    public List<ProductCommentEntity> getAll() {
        return productCommentJpaRepository.findAll();
    }
}
