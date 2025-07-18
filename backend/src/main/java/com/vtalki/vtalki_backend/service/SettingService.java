package com.vtalki.vtalki_backend.service;

import com.vtalki.vtalki_backend.entity.setting.SettingEntity;

import java.util.List;
import java.util.Optional;

public interface SettingService {
    List<SettingEntity> getAll();

    Optional<SettingEntity> getById(String id);

    SettingEntity create(SettingEntity setting);

    SettingEntity update(String id, SettingEntity setting);

    void delete(String id);
}
