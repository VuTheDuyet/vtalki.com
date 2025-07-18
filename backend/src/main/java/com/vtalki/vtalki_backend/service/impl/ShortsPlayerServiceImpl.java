package com.vtalki.vtalki_backend.service.impl;

import com.vtalki.vtalki_backend.entity.shortsplayer.ShortsPlayerEntity;
import com.vtalki.vtalki_backend.repository.ShortsplayerRepository;
import com.vtalki.vtalki_backend.service.ShortsPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ShortsPlayerServiceImpl implements ShortsPlayerService {

    @Autowired
    private ShortsplayerRepository shortsplayerRepository;

    @Override
    public List<ShortsPlayerEntity> getAll() {
        return shortsplayerRepository.findAll();
    }

    @Override
    public Optional<ShortsPlayerEntity> getById(String id) {
        return shortsplayerRepository.findById(id);
    }

    @Override
    public ShortsPlayerEntity save(ShortsPlayerEntity shortsPlayerEntity) {
        return shortsplayerRepository.save(shortsPlayerEntity);
    }

    @Override
    public ShortsPlayerEntity update(String id, ShortsPlayerEntity updatedShort) {
        ShortsPlayerEntity existing = shortsplayerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy shorts với id: " + id));

        existing.setIdYoutube(updatedShort.getIdYoutube());
        existing.setLinkUrl(updatedShort.getLinkUrl());
        existing.setStatus(updatedShort.getStatus());

        return shortsplayerRepository.save(existing);
    }

    @Override
    public void delete(String id) {
        if (!shortsplayerRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy shorts để xóa với id: " + id);
        }
        shortsplayerRepository.deleteById(id);
    }

    @Override
    public List<ShortsPlayerEntity> getByStatus(boolean status) {
        return shortsplayerRepository.findByStatus(status);
    }

    @Override
    @Transactional
    public void updateStatusBulk(List<String> ids, boolean status) {
        List<ShortsPlayerEntity> shortsList = shortsplayerRepository.findAllById(ids);
        for (ShortsPlayerEntity shortItem : shortsList) {
            shortItem.setStatus(status);
        }
        shortsplayerRepository.saveAll(shortsList);
    }

}
