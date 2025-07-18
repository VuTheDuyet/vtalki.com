package com.vtalki.vtalki_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtalki.vtalki_backend.entity.floatbutton.FloatButtonEntity;

public interface FloatButtonRepository extends JpaRepository<FloatButtonEntity, String> {
    List<FloatButtonEntity> findByActive(boolean active);

}