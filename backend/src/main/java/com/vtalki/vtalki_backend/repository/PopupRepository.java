package com.vtalki.vtalki_backend.repository;

import com.vtalki.vtalki_backend.entity.popup.PopupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PopupRepository extends JpaRepository<PopupEntity, String> {
    List<PopupEntity> findAllByStatusTrue(); // popup đang hoạt động
}
