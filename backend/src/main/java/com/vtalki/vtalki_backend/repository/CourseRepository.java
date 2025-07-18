package com.vtalki.vtalki_backend.repository;

import com.vtalki.vtalki_backend.entity.courses.CoursesEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CoursesEntity, String> {
    List<CoursesEntity> findByStatus(boolean status);
}