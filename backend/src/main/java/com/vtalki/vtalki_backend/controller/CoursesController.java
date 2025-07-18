package com.vtalki.vtalki_backend.controller;

import com.vtalki.vtalki_backend.dto.BulkUpdateRequest;
import com.vtalki.vtalki_backend.entity.courses.CoursesEntity;
import com.vtalki.vtalki_backend.service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CoursesController {

    private final CoursesService coursesService;

    // ✅ GET ALL
    @GetMapping
    public ResponseEntity<List<CoursesEntity>> getAllCourses() {
        List<CoursesEntity> courses = coursesService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<CoursesEntity> getCourseById(@PathVariable String id) {
        return coursesService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<CoursesEntity> createCourse(@RequestBody CoursesEntity course) {
        CoursesEntity created = coursesService.createCourse(course);
        return ResponseEntity.ok(created);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<CoursesEntity> updateCourse(
            @PathVariable String id,
            @RequestBody CoursesEntity updatedCourse) {
        return coursesService.updateCourse(id, updatedCourse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        coursesService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/bulk-update-status")
    public ResponseEntity<?> updateStatusBulk(@RequestBody BulkUpdateRequest request) {
        coursesService.updateStatusBulk(request.getIds(), request.getStatus());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<CoursesEntity>> getActiveCourses() {
        List<CoursesEntity> activeCourses = coursesService.getCoursesByStatus(true);
        return ResponseEntity.ok(activeCourses);
    }
}
