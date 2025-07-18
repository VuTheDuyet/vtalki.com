package com.vtalki.vtalki_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtalki.vtalki_backend.entity.courses.CourseHomeEntity;

public interface CourseHomeRepository extends JpaRepository<CourseHomeEntity, String> {
    List<CourseHomeEntity> findByStatus(boolean status);
}