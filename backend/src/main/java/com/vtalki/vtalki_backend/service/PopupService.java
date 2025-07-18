package com.vtalki.vtalki_backend.service;

import com.vtalki.vtalki_backend.entity.popup.PopupEntity;

import java.util.List;

public interface PopupService {
    List<PopupEntity> getAll();

    PopupEntity getById(String id);

    PopupEntity create(PopupEntity popup);

    PopupEntity update(String id, PopupEntity popup);

    void delete(String id);
}