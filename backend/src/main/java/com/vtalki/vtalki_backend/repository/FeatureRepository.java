package com.vtalki.vtalki_backend.repository;

import com.vtalki.vtalki_backend.entity.feature.FeatureEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<FeatureEntity, String> {
    List<FeatureEntity> findByStatus(boolean status);
}
