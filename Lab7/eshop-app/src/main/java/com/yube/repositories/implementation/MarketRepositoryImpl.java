package com.yube.repositories.implementation;

import com.yube.model.entity.MarketEntity;
import com.yube.repositories.declaration.MarketRepository;
import com.yube.repositories.jpa.MarketJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
@AllArgsConstructor
public class MarketRepositoryImpl implements MarketRepository {

    private final MarketJpaRepository marketJpaRepository;

    @Override
    public MarketEntity create(MarketEntity entity) {
        return marketJpaRepository.save(entity);
    }

    @Override
    public MarketEntity update(MarketEntity entity) {
        return marketJpaRepository.save(entity);
    }

    @Override
    public void delete(MarketEntity entity) {
        marketJpaRepository.delete(entity);
    }

    @Override
    public Optional<MarketEntity> get(UUID id) {
        return marketJpaRepository.findById(id);
    }

    @Override
    public List<MarketEntity> getAll() {
        return marketJpaRepository.findAll();
    }
}
