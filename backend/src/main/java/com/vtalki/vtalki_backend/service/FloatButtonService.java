package com.vtalki.vtalki_backend.service;

import com.vtalki.vtalki_backend.entity.floatbutton.FloatButtonEntity;

import java.util.List;
import java.util.Optional;

public interface FloatButtonService {

    List<FloatButtonEntity> getAll();

    Optional<FloatButtonEntity> getById(String id);

    FloatButtonEntity create(FloatButtonEntity button);

    FloatButtonEntity update(String id, FloatButtonEntity button);

    void delete(String id);

    // ✅ Bổ sung: lấy theo trạng thái (true = hiển thị, false = ẩn)
    List<FloatButtonEntity> getByStatus(boolean status);

    // ✅ Bổ sung: cập nhật trạng thái hàng loạt (ẩn/hiện nhiều cái cùng lúc)
    void updateStatusBulk(List<String> ids, boolean status);
}
