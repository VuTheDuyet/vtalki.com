package com.vtalki.vtalki_backend.controller;

import com.vtalki.vtalki_backend.dto.BulkUpdateRequest;
import com.vtalki.vtalki_backend.entity.question.QuestionEntity;
import com.vtalki.vtalki_backend.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // Lấy tất cả câu hỏi
    @GetMapping
    public ResponseEntity<List<QuestionEntity>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAll());
    }

    // Lấy câu hỏi theo trạng thái
    @GetMapping("/active")
    public ResponseEntity<List<QuestionEntity>> getActiveQuestions() {
        return ResponseEntity.ok(questionService.getByStatus(true));
    }

    // Lấy câu hỏi theo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable String id) {
        return questionService.getById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("Không tìm thấy câu hỏi với ID: " + id));
    }

    // Tạo mới câu hỏi
    @PostMapping
    public ResponseEntity<QuestionEntity> createQuestion(@RequestBody QuestionEntity question) {
        return ResponseEntity.ok(questionService.save(question));
    }

    // Cập nhật câu hỏi
    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuestion(@PathVariable String id, @RequestBody QuestionEntity question) {
        try {
            return ResponseEntity.ok(questionService.update(id, question));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Không tìm thấy câu hỏi để cập nhật: " + e.getMessage());
        }
    }

    // Xóa câu hỏi
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable String id) {
        try {
            questionService.delete(id);
            return ResponseEntity.ok("Đã xoá câu hỏi với ID: " + id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Không tìm thấy câu hỏi để xoá: " + e.getMessage());
        }
    }

    // Cập nhật trạng thái hàng loạt
    @PutMapping("/bulk-update-status")
    public ResponseEntity<?> bulkUpdateStatus(@RequestBody BulkUpdateRequest request) {
        if (request.getIds() == null || request.getIds().isEmpty()) {
            return ResponseEntity.badRequest().body("Danh sách ID không được để trống");
        }

        try {
            questionService.updateStatusBulk(request.getIds(), request.getStatus());
            return ResponseEntity.ok("Đã cập nhật trạng thái cho " + request.getIds().size() + " câu hỏi");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi cập nhật trạng thái: " + e.getMessage());
        }
    }
}
