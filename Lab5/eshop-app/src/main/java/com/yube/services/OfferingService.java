package com.yube.services;

import com.yube.model.dto.Offering;
import com.yube.model.entity.OfferingEntity;
import com.yube.model.mapping.OfferingMapper;
import com.yube.model.mapping.utils.MappingUtils;
import com.yube.repositories.declaration.OfferingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class OfferingService {

    private final OfferingMapper offeringMapper;
    private final OfferingRepository offeringRepository;

    public List<Offering> getAll() {
        return MappingUtils.mapAll(offeringRepository.getAll(), offeringMapper::map);
    }

    public Offering getById(String id) {
        return offeringMapper.map(offeringRepository.get(UUID.fromString(id)).get());
    }

    public Offering getDefault() {
        return offeringMapper.map(offeringRepository.findFirstBy().orElse(null));
    }

    public Offering create(Offering offering) {
        OfferingEntity offeringEntity = offeringMapper.unmap(offering);
        return offeringMapper.map(offeringRepository.create(offeringEntity));
    }

    public Offering update(Offering offering) {
        OfferingEntity sourceOfferingEntity = offeringMapper.unmap(offering);
        OfferingEntity targetOfferingEntity = offeringRepository.get(sourceOfferingEntity.getId()).get();
        BeanUtils.copyProperties(sourceOfferingEntity, targetOfferingEntity);
        OfferingEntity updatedOfferingEntity = offeringRepository.update(targetOfferingEntity);
        return offeringMapper.map(updatedOfferingEntity);
    }

    public void delete(String id) {
        offeringRepository.delete(UUID.fromString(id));
    }
}
