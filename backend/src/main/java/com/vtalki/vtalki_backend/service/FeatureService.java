package com.vtalki.vtalki_backend.service;

import com.vtalki.vtalki_backend.entity.feature.FeatureEntity;

import java.util.List;
import java.util.Optional;

public interface FeatureService {
    List<FeatureEntity> getAll();

    Optional<FeatureEntity> getById(String id);

    FeatureEntity create(FeatureEntity feature);

    FeatureEntity update(String id, FeatureEntity feature);

    void delete(String id);

    // ✅ Bổ sung cho tính năng filter theo trạng thái
    List<FeatureEntity> getByStatus(boolean status);

    // ✅ Bổ sung cập nhật trạng thái hàng loạt
    void updateStatusBulk(List<String> ids, boolean status);
}
