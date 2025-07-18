package com.vtalki.vtalki_backend.service.impl;

import com.vtalki.vtalki_backend.entity.feature.FeatureEntity;
import com.vtalki.vtalki_backend.repository.FeatureRepository;
import com.vtalki.vtalki_backend.service.FeatureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @Override
    public List<FeatureEntity> getAll() {
        return featureRepository.findAll();
    }

    @Override
    public Optional<FeatureEntity> getById(String id) {
        return featureRepository.findById(id);
    }

    @Override
    public FeatureEntity create(FeatureEntity feature) {
        return featureRepository.save(feature);
    }

    @Override
    public FeatureEntity update(String id, FeatureEntity feature) {
        FeatureEntity existing = featureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Feature với id: " + id));

        existing.setIcon(feature.getIcon());

        existing.setTitleVi(feature.getTitleVi());
        existing.setDescriptionVi(feature.getDescriptionVi());

        existing.setTitleEn(feature.getTitleEn());
        existing.setDescriptionEn(feature.getDescriptionEn());

        existing.setTitleKo(feature.getTitleKo());
        existing.setDescriptionKo(feature.getDescriptionKo());

        existing.setStatus(feature.isStatus());

        return featureRepository.save(existing);
    }

    @Override
    public void delete(String id) {
        if (!featureRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy Feature với id: " + id);
        }
        featureRepository.deleteById(id);
    }

    @Override
    public List<FeatureEntity> getByStatus(boolean status) {
        return featureRepository.findByStatus(status);
    }

    @Override
    public void updateStatusBulk(List<String> ids, boolean status) {
        List<FeatureEntity> features = featureRepository.findAllById(ids);
        for (FeatureEntity feature : features) {
            feature.setStatus(status);
        }
        featureRepository.saveAll(features);
    }
}
