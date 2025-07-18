package com.vtalki.vtalki_backend.service;

import java.util.List;
import java.util.Optional;

import com.vtalki.vtalki_backend.entity.shortsplayer.ShortsPlayerEntity;

public interface ShortsPlayerService {

    List<ShortsPlayerEntity> getAll();

    Optional<ShortsPlayerEntity> getById(String id);

    ShortsPlayerEntity save(ShortsPlayerEntity shortsPlayerEntity);

    ShortsPlayerEntity update(String id, ShortsPlayerEntity shortsPlayerEntity);

    void delete(String id);

    // ✅ Lọc theo trạng thái hiển thị (public/hidden)
    List<ShortsPlayerEntity> getByStatus(boolean status);

    // ✅ Bật/tắt trạng thái hiển thị hàng loạt
    void updateStatusBulk(List<String> ids, boolean status);
}
