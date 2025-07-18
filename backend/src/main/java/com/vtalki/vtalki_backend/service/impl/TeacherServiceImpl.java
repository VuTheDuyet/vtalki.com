package com.vtalki.vtalki_backend.service.impl;

import com.vtalki.vtalki_backend.entity.teachers.TeacherEntity;
import com.vtalki.vtalki_backend.repository.TeacherRepository;
import com.vtalki.vtalki_backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    private final String avatarBasePath = "uploads/teachers/";

    private void deleteAvatarFile(String avatarUrl) {
        if (avatarUrl != null && !avatarUrl.isEmpty()) {
            try {
                Path filePath = Paths.get(avatarBasePath, Paths.get(avatarUrl).getFileName().toString());
                Files.deleteIfExists(filePath);
            } catch (IOException e) {
                System.err.println("Không thể xóa ảnh: " + avatarUrl);
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<TeacherEntity> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<TeacherEntity> getById(String id) {
        return teacherRepository.findById(id);
    }

    @Override
    public TeacherEntity save(TeacherEntity teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public TeacherEntity update(String id, TeacherEntity updated) {
        TeacherEntity teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giáo viên với id: " + id));

        // Nếu avatar thay đổi => xóa ảnh cũ
        if (updated.getAvatarUrl() != null && !updated.getAvatarUrl().equals(teacher.getAvatarUrl())) {
            deleteAvatarFile(teacher.getAvatarUrl());
            teacher.setAvatarUrl(updated.getAvatarUrl());
        }

        teacher.setName(updated.getName());
        teacher.setDob(updated.getDob());
        teacher.setGender(updated.getGender());
        teacher.setBirthplace(updated.getBirthplace());
        teacher.setActive(updated.isActive());
        teacher.setRating(updated.getRating());
        teacher.setReviewsCount(updated.getReviewsCount());
        teacher.setLanguagesSpoken(updated.getLanguagesSpoken());
        teacher.setBioVi(updated.getBioVi());
        teacher.setBioEn(updated.getBioEn());
        teacher.setBioKo(updated.getBioKo());
        teacher.setTeachingIntroVi(updated.getTeachingIntroVi());
        teacher.setTeachingIntroEn(updated.getTeachingIntroEn());
        teacher.setTeachingIntroKo(updated.getTeachingIntroKo());
        teacher.setCertificates(updated.getCertificates());
        teacher.setExperience(updated.getExperience());

        return teacherRepository.save(teacher);
    }

    @Override
    public void delete(String id) {
        TeacherEntity teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giáo viên để xóa với id: " + id));

        deleteAvatarFile(teacher.getAvatarUrl());
        teacherRepository.deleteById(id);
    }

    @Override
    public TeacherEntity updateAvatar(String teacherId, String avatarUrl) {
        TeacherEntity teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giáo viên với id: " + teacherId));

        // Nếu avatar thay đổi => xóa ảnh cũ
        if (avatarUrl != null && !avatarUrl.equals(teacher.getAvatarUrl())) {
            deleteAvatarFile(teacher.getAvatarUrl());
            teacher.setAvatarUrl(avatarUrl);
        }

        return teacherRepository.save(teacher);
    }

    @Override
    public List<TeacherEntity> getByStatus(boolean status) {
        return teacherRepository.findByActive(status);
    }

    @Override
    @Transactional
    public void updateStatusBulk(List<String> ids, boolean status) {
        List<TeacherEntity> teachers = teacherRepository.findAllById(ids);
        for (TeacherEntity teacher : teachers) {
            teacher.setActive(status);
        }
        teacherRepository.saveAll(teachers);
    }
}
