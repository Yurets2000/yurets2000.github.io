package com.yube.repositories.jpa;

import com.yube.model.entity.BannerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BannerJpaRepository extends BaseJpaRepository<BannerEntity> {
    long count();
    Page<BannerEntity> findAll(Pageable pageable);
}
