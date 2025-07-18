package com.vtalki.vtalki_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.vtalki.vtalki_backend.dto.BulkUpdateRequest;
import com.vtalki.vtalki_backend.entity.teachers.TeacherEntity;
import com.vtalki.vtalki_backend.service.TeacherService;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<TeacherEntity> getAllTeachers() {
        return teacherService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> createTeacher(@RequestBody TeacherEntity teacher) {
        try {
            System.out.println("📥 Đã nhận: " + teacher);
            TeacherEntity saved = teacherService.save(teacher);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            e.printStackTrace(); // ❗❗❗ IN RA LỖI Ở ĐÂY ❗❗❗
            return ResponseEntity.status(500).body("Lỗi backend: " + e.getMessage());
        }
    }

    @PostMapping("/{id}/upload-avatar")
    public ResponseEntity<?> uploadAvatar(
            @PathVariable String id,
            @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File không được để trống");
        }

        String filename = id + "-" + file.getOriginalFilename();
        Path uploadPath = Paths.get("uploads/teachers");

        try {
            Files.createDirectories(uploadPath);
            Path filePath = uploadPath.resolve(filename);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Lỗi khi lưu file: " + e.getMessage());
        }

        String avatarUrl = "/uploads/teachers/" + filename;

        try {
            teacherService.updateAvatar(id, avatarUrl);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Không thể cập nhật giáo viên: " + e.getMessage());
        }

        return ResponseEntity.ok(avatarUrl);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable String id) {
        try {
            teacherService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Không thể xoá giáo viên: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherEntity> getTeacherById(@PathVariable String id) {
        return teacherService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable String id, @RequestBody TeacherEntity updatedTeacher) {
        try {
            TeacherEntity updated = teacherService.update(id, updatedTeacher);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi cập nhật: " + e.getMessage());
        }
    }

    @PutMapping("/bulk-update-status")
    public ResponseEntity<?> updateStatusBulk(@RequestBody BulkUpdateRequest request) {
        try {
            teacherService.updateStatusBulk(request.getIds(), request.getStatus());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi cập nhật trạng thái: " + e.getMessage());
        }
    }

    @GetMapping("/active")
    public ResponseEntity<List<TeacherEntity>> getActiveTeachers() {
        List<TeacherEntity> activeTeachers = teacherService.getByStatus(true);
        return ResponseEntity.ok(activeTeachers);
    }

}