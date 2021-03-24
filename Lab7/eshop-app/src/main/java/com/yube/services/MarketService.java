package com.yube.services;

import com.yube.model.dto.Market;
import com.yube.model.entity.MarketEntity;
import com.yube.model.mapping.MarketMapper;
import com.yube.model.mapping.utils.MappingUtils;
import com.yube.repositories.declaration.MarketRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class MarketService {

    private final MarketMapper marketMapper;
    private final MarketRepository marketRepository;

    public List<Market> getAll() {
        return MappingUtils.mapAll(marketRepository.getAll(), marketMapper::map);
    }

    public Market getById(String id) {
        return marketMapper.map(marketRepository.get(UUID.fromString(id)).get());
    }

    public Market create(Market market) {
        MarketEntity marketEntity = marketMapper.unmap(market);
        return marketMapper.map(marketRepository.create(marketEntity));
    }

    public Market update(Market market) {
        MarketEntity sourceMarketEntity = marketMapper.unmap(market);
        MarketEntity targetMarketEntity = marketRepository.get(sourceMarketEntity.getId()).get();
        BeanUtils.copyProperties(sourceMarketEntity, targetMarketEntity);
        MarketEntity updatedMarketEntity = marketRepository.update(targetMarketEntity);
        return marketMapper.map(updatedMarketEntity);
    }

    public void delete(String id) {
        marketRepository.delete(UUID.fromString(id));
    }
}
