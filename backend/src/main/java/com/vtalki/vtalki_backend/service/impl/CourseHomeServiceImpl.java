package com.vtalki.vtalki_backend.service.impl;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtalki.vtalki_backend.entity.courses.CourseHomeEntity;
import com.vtalki.vtalki_backend.repository.CourseHomeRepository;
import com.vtalki.vtalki_backend.service.CourseHomeService;

@Service
public class CourseHomeServiceImpl implements CourseHomeService {

    @Autowired
    private CourseHomeRepository courseHomRepository;

    private final String uploadDir = "uploads/coursehome";

    @Override
    public List<CourseHomeEntity> getAll() {
        return courseHomRepository.findAll();
    }

    @Override
    public Optional<CourseHomeEntity> getById(String id) {
        return courseHomRepository.findById(id);
    }

    @Override
    public CourseHomeEntity save(CourseHomeEntity coursehome) {
        return courseHomRepository.save(coursehome);
    }

    @Override
    public void delete(String id) {
        CourseHomeEntity courseHome = courseHomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học: " + id));

        deleteImageFile(courseHome.getImage()); // 💥 Xoá file ảnh nếu có

        courseHomRepository.deleteById(id);
    }

    @Override
    public CourseHomeEntity updateAvatar(String id, String newAvatar) {
        CourseHomeEntity courseHome = courseHomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học: " + id));

        deleteImageFile(courseHome.getImage()); // 💥 Xoá ảnh cũ

        courseHome.setImage(newAvatar);
        return courseHomRepository.save(courseHome);
    }

    @Override
    public CourseHomeEntity update(String id, CourseHomeEntity newData) {
        CourseHomeEntity courseHome = courseHomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học: " + id));

        // 💥 Xoá ảnh cũ nếu bị thay đổi
        if (newData.getImage() != null && !newData.getImage().equals(courseHome.getImage())) {
            deleteImageFile(courseHome.getImage());
            courseHome.setImage(newData.getImage());
        }

        courseHome.setLink(newData.getLink());
        courseHome.setOriginalPrice(newData.getOriginalPrice());
        courseHome.setDiscountedPrice(newData.getDiscountedPrice());

        courseHome.setLanguageVi(newData.getLanguageVi());
        courseHome.setLanguageEn(newData.getLanguageEn());
        courseHome.setLanguageKo(newData.getLanguageKo());

        courseHome.setDescriptionVi(newData.getDescriptionVi());
        courseHome.setDescriptionEn(newData.getDescriptionEn());
        courseHome.setDescriptionKo(newData.getDescriptionKo());

        courseHome.setLevelsVi(newData.getLevelsVi());
        courseHome.setLevelsEn(newData.getLevelsEn());
        courseHome.setLevelsKo(newData.getLevelsKo());

        return courseHomRepository.save(courseHome);
    }

    @Override
    public void updateStatusBulk(List<String> ids, boolean status) {
        List<CourseHomeEntity> courses = courseHomRepository.findAllById(ids);
        for (CourseHomeEntity course : courses) {
            course.setStatus(status);
        }
        courseHomRepository.saveAll(courses);
    }

    @Override
    public List<CourseHomeEntity> getCoursesHomeByStatus(boolean status) {
        return courseHomRepository.findByStatus(status);
    }

    // 🔥 Hàm xoá ảnh cũ
    private void deleteImageFile(String imagePath) {
        if (imagePath != null && !imagePath.isBlank()) {
            String fileName = new File(imagePath).getName(); // lấy phần tên ảnh cuối cùng
            File file = new File(uploadDir + File.separator + fileName);
            if (file.exists()) {
                boolean deleted = file.delete();
                if (!deleted) {
                    System.err.println("❌ Không thể xoá ảnh: " + file.getAbsolutePath());
                }
            }
        }
    }
}
