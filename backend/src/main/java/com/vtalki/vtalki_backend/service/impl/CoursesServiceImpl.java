package com.vtalki.vtalki_backend.service.impl;

import com.vtalki.vtalki_backend.entity.courses.CoursesEntity;
import com.vtalki.vtalki_backend.repository.CourseRepository;
import com.vtalki.vtalki_backend.service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl implements CoursesService {

    private final CourseRepository coursesRepository;

    @Override
    public List<CoursesEntity> getAllCourses() {
        return coursesRepository.findAll();
    }

    @Override
    public Optional<CoursesEntity> getCourseById(String id) {
        return coursesRepository.findById(id);
    }

    @Override
    public CoursesEntity createCourse(CoursesEntity course) {
        return coursesRepository.save(course);
    }

    @Override
    public Optional<CoursesEntity> updateCourse(String id, CoursesEntity updatedCourse) {
        return coursesRepository.findById(id).map(existing -> {
            updatedCourse.setCourseId(id); // giữ lại ID cũ
            updatedCourse.setCreatedDate(existing.getCreatedDate()); // không update createDate
            return coursesRepository.save(updatedCourse);
        });
    }

    @Override
    public void deleteCourse(String id) {
        coursesRepository.deleteById(id);
    }

    @Override
    public void updateStatusBulk(List<String> ids, boolean status) {
        List<CoursesEntity> courses = coursesRepository.findAllById(ids);
        for (CoursesEntity course : courses) {
            course.setStatus(status);
        }
        coursesRepository.saveAll(courses);
    }

    @Override
    public List<CoursesEntity> getCoursesByStatus(boolean status) {
        return coursesRepository.findByStatus(status);
    }

}