package com.vtalki.vtalki_backend.repository;

import com.vtalki.vtalki_backend.entity.teachers.TeacherEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, String> {
    List<TeacherEntity> findByActive(boolean active);
}