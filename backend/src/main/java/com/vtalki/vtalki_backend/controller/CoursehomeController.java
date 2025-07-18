package com.vtalki.vtalki_backend.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.vtalki.vtalki_backend.dto.BulkUpdateRequest;
import com.vtalki.vtalki_backend.entity.courses.CourseHomeEntity;
import com.vtalki.vtalki_backend.service.CourseHomeService;

@RestController
@RequestMapping("/api/coursehome")
public class CoursehomeController {

    @Autowired
    private CourseHomeService courseHomeService;

    @GetMapping
    public List<CourseHomeEntity> getAllCourseHome() {
        return courseHomeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CourseHomeEntity> getById(@PathVariable String id) {
        return courseHomeService.getById(id);
    }

    @PostMapping
    public CourseHomeEntity createCourseHome(@RequestBody CourseHomeEntity courseHome) {
        return courseHomeService.save(courseHome);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseHomeEntity> updateCourseHome(
            @PathVariable String id,
            @RequestBody CourseHomeEntity updatedCourse) {
        CourseHomeEntity result = courseHomeService.update(id, updatedCourse);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{id}/upload-avatar")
    public ResponseEntity<?> uploadAvatarCourseHome(
            @PathVariable String id,
            @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("file cannot be empty");
        }

        String filename = id + "-" + file.getOriginalFilename();
        Path uploadPath = Paths.get("uploads/coursehome");
        try {
            Files.createDirectories(uploadPath);
            Path filePath = uploadPath.resolve(filename);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("error save file: " + e.getMessage());
        }

        String avatarURL = "/uploads/coursehome/" + filename;
        try {
            courseHomeService.updateAvatar(id, avatarURL);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("not update course :" + e.getMessage());
        }

        return ResponseEntity.ok(avatarURL);
    }

    @PutMapping("/bulk-update-status")
    public ResponseEntity<?> updateStatusBulk(@RequestBody BulkUpdateRequest request) {
        courseHomeService.updateStatusBulk(request.getIds(), request.getStatus());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<CourseHomeEntity>> getActiveCourses() {
        List<CourseHomeEntity> activeCourses = courseHomeService.getCoursesHomeByStatus(true);
        return ResponseEntity.ok(activeCourses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourseHome(@PathVariable String id) {
        try {
            courseHomeService.delete(id);
            return ResponseEntity.ok("Đã xóa khóa học và hình ảnh thành công");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("❌ Không tìm thấy khóa học: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("❌ Lỗi khi xóa khóa học: " + e.getMessage());
        }
    }

}
