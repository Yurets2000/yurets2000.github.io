package com.yube.repositories.implementation;

import com.yube.model.entity.BannerEntity;
import com.yube.repositories.declaration.BannerRepository;
import com.yube.repositories.jpa.BannerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
@AllArgsConstructor
public class BannerRepositoryImpl implements BannerRepository {

    private final BannerJpaRepository bannerJpaRepository;
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public BannerEntity create(BannerEntity entity) {
        return bannerJpaRepository.save(entity);
    }

    @Override
    public BannerEntity update(BannerEntity entity) {
        return bannerJpaRepository.save(entity);
    }

    @Override
    public void delete(BannerEntity entity) {
        bannerJpaRepository.delete(entity);
    }

    @Override
    public Optional<BannerEntity> get(UUID id) {
        return bannerJpaRepository.findById(id);
    }

    @Override
    public List<BannerEntity> getAll() {
        return bannerJpaRepository.findAll();
    }

    @Override
    public BannerEntity getRandom() {
        long qty = bannerJpaRepository.count();
        int idx = (int) (Math.random() * qty);
        Pageable pageable = PageRequest.of(idx, 1);
        Page<BannerEntity> bannerPage = bannerJpaRepository.findAll(pageable);
        BannerEntity bannerEntity = null;
        if (bannerPage.hasContent()) {
            bannerEntity = bannerPage.getContent().get(0);
        }
        return bannerEntity;
    }
}
