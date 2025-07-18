
package com.vtalki.vtalki_backend.service;

import java.util.List;
import java.util.Optional;

import com.vtalki.vtalki_backend.entity.courses.CourseHomeEntity;

public interface CourseHomeService {

    List<CourseHomeEntity> getAll();

    Optional<CourseHomeEntity> getById(String id);

    CourseHomeEntity save(CourseHomeEntity couserhome);

    CourseHomeEntity update(String id, CourseHomeEntity coursehome);

    void delete(String id);

    CourseHomeEntity updateAvatar(String id, String avatar);

    void updateStatusBulk(List<String> ids, boolean status);

    List<CourseHomeEntity> getCoursesHomeByStatus(boolean status);

}
