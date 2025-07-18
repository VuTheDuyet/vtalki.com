package com.vtalki.vtalki_backend.service;

import com.vtalki.vtalki_backend.entity.courses.CoursesEntity;

import java.util.List;
import java.util.Optional;

public interface CoursesService {
    List<CoursesEntity> getAllCourses();

    Optional<CoursesEntity> getCourseById(String id);

    CoursesEntity createCourse(CoursesEntity dto);

    Optional<CoursesEntity> updateCourse(String id, CoursesEntity dto);

    void deleteCourse(String id);

    void updateStatusBulk(List<String> ids, boolean status);

    List<CoursesEntity> getCoursesByStatus(boolean status);

}
