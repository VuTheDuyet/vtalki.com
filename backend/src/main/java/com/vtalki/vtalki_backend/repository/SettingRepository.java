package com.vtalki.vtalki_backend.repository;

import com.vtalki.vtalki_backend.entity.setting.SettingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingRepository extends JpaRepository<SettingEntity, String> {
}
