package com.yube.services;

import com.yube.model.dto.Banner;
import com.yube.model.mapping.BannerMapper;
import com.yube.model.mapping.utils.MappingUtils;
import com.yube.repositories.declaration.BannerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class BannerService {

    private final BannerMapper bannerMapper;
    private final BannerRepository bannerRepository;

    public List<Banner> getAll() {
        return MappingUtils.mapAll(bannerRepository.getAll(), bannerMapper::map);
    }

    public Banner getById(String id) {
        return bannerMapper.map(bannerRepository.get(UUID.fromString(id)).get());
    }

    public Banner getRandom() {
        return bannerMapper.map(bannerRepository.getRandom());
    }
}
