package com.vtalki.vtalki_backend.service;

import com.vtalki.vtalki_backend.entity.teachers.TeacherEntity;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    List<TeacherEntity> getAll();

    Optional<TeacherEntity> getById(String id);

    TeacherEntity save(TeacherEntity teacher);

    TeacherEntity update(String id, TeacherEntity updatedTeacher);

    void delete(String id);

    // ✅ Cập nhật avatar giảng viên (khi upload ảnh mới)
    TeacherEntity updateAvatar(String teacherId, String avatarUrl);

    // ✅ Lọc giảng viên theo trạng thái (active / inactive)
    List<TeacherEntity> getByStatus(boolean status);

    // ✅ Bật/tắt nhiều giảng viên cùng lúc
    void updateStatusBulk(List<String> ids, boolean status);

}
