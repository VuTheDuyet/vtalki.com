package com.vtalki.vtalki_backend.service.impl;

import com.vtalki.vtalki_backend.entity.popup.PopupEntity;
import com.vtalki.vtalki_backend.repository.PopupRepository;
import com.vtalki.vtalki_backend.service.PopupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopupServiceImpl implements PopupService {

    @Autowired
    private PopupRepository popupRepository;

    @Override
    public List<PopupEntity> getAll() {
        return popupRepository.findAll();
    }

    @Override
    public PopupEntity getById(String id) {
        return popupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy popup với ID: " + id));
    }

    @Override
    public PopupEntity create(PopupEntity popup) {
        return popupRepository.save(popup);
    }

    @Override
    public PopupEntity update(String id, PopupEntity popup) {
        PopupEntity existing = getById(id);
        existing.setMainVideoUrl(popup.getMainVideoUrl());
        existing.setPopupVideoUrl(popup.getPopupVideoUrl());

        existing.setTitleVi(popup.getTitleVi());
        existing.setTitleEn(popup.getTitleEn());
        existing.setTitleKo(popup.getTitleKo());

        existing.setDescriptionPopupVi(popup.getDescriptionPopupVi());
        existing.setDescriptionPopupEn(popup.getDescriptionPopupEn());
        existing.setDescriptionPopupKo(popup.getDescriptionPopupKo());

        existing.setVideoAbout(popup.getVideoAbout());
        existing.setStatus(popup.getStatus());

        return popupRepository.save(existing);
    }

    @Override
    public void delete(String id) {
        popupRepository.deleteById(id);
    }
}
