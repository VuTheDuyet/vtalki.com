package com.vtalki.vtalki_backend.service.impl;

import com.vtalki.vtalki_backend.entity.setting.SettingEntity;
import com.vtalki.vtalki_backend.repository.SettingRepository;
import com.vtalki.vtalki_backend.service.SettingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettingServiceImpl implements SettingService {

    private final SettingRepository settingRepository;

    public SettingServiceImpl(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    @Override
    public List<SettingEntity> getAll() {
        return settingRepository.findAll();
    }

    @Override
    public Optional<SettingEntity> getById(String id) {
        return settingRepository.findById(id);
    }

    @Override
    public SettingEntity create(SettingEntity setting) {
        return settingRepository.save(setting);
    }

    @Override
    public SettingEntity update(String id, SettingEntity setting) {
        SettingEntity existing = settingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy setting với id: " + id));

        existing.setBrandName(setting.getBrandName());
        existing.setSlogan(setting.getSlogan());
        existing.setLogoImage(setting.getLogoImage());
        existing.setAddress(setting.getAddress());
        existing.setPhone(setting.getPhone());
        existing.setEmail(setting.getEmail());
        existing.setMapLink(setting.getMapLink());
        existing.setVideoLink(setting.getVideoLink());
        existing.setStatus(setting.getStatus());

        return settingRepository.save(existing);
    }

    @Override
    public void delete(String id) {
        if (!settingRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy setting với id: " + id);
        }
        settingRepository.deleteById(id);
    }
}
