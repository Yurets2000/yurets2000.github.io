package com.yube.repositories.implementation;

import com.yube.model.entity.OfferingEntity;
import com.yube.repositories.declaration.OfferingRepository;
import com.yube.repositories.jpa.OfferingJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
@AllArgsConstructor
public class OfferingRepositoryImpl implements OfferingRepository {

    private final OfferingJpaRepository offeringJpaRepository;

    @Override
    public OfferingEntity create(OfferingEntity entity) {
        return offeringJpaRepository.save(entity);
    }

    @Override
    public OfferingEntity update(OfferingEntity entity) {
        return offeringJpaRepository.save(entity);
    }

    @Override
    public void delete(OfferingEntity entity) {
        offeringJpaRepository.delete(entity);
    }

    @Override
    public Optional<OfferingEntity> get(UUID id) {
        return offeringJpaRepository.findById(id);
    }

    @Override
    public List<OfferingEntity> getAll() {
        return offeringJpaRepository.findAll();
    }

    @Override
    public Optional<OfferingEntity> findFirstBy() {
        return offeringJpaRepository.findFirstBy();
    }
}
