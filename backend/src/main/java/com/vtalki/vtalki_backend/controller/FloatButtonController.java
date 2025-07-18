package com.vtalki.vtalki_backend.controller;

import com.vtalki.vtalki_backend.dto.BulkUpdateRequest;
import com.vtalki.vtalki_backend.entity.floatbutton.FloatButtonEntity;
import com.vtalki.vtalki_backend.service.FloatButtonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/float-buttons")
public class FloatButtonController {

    private final FloatButtonService floatButtonService;

    public FloatButtonController(FloatButtonService floatButtonService) {
        this.floatButtonService = floatButtonService;
    }

    // Lấy toàn bộ
    @GetMapping
    public ResponseEntity<List<FloatButtonEntity>> getAll() {
        return ResponseEntity.ok(floatButtonService.getAll());
    }

    // Lấy theo trạng thái
    @GetMapping("/status/{active}")
    public ResponseEntity<List<FloatButtonEntity>> getByStatus(@PathVariable boolean active) {
        return ResponseEntity.ok(floatButtonService.getByStatus(active));
    }

    // Lấy theo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return floatButtonService.getById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("Không tìm thấy nút với ID: " + id));
    }

    // Tạo mới
    @PostMapping
    public ResponseEntity<FloatButtonEntity> create(@RequestBody FloatButtonEntity button) {
        return ResponseEntity.ok(floatButtonService.create(button));
    }

    // Cập nhật
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody FloatButtonEntity button) {
        try {
            return ResponseEntity.ok(floatButtonService.update(id, button));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    // Xoá
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            floatButtonService.delete(id);
            return ResponseEntity.ok("Đã xoá float button với ID: " + id);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Cập nhật trạng thái hàng loạt
    @PutMapping("/bulk-update-status")
    public ResponseEntity<?> updateStatusBulk(@RequestBody BulkUpdateRequest request) {
        if (request.getIds() == null || request.getIds().isEmpty()) {
            return ResponseEntity.badRequest().body("Danh sách ID không được để trống");
        }

        try {
            floatButtonService.updateStatusBulk(request.getIds(), request.getStatus());
            return ResponseEntity.ok("Đã cập nhật trạng thái cho " + request.getIds().size() + " nút");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi cập nhật trạng thái: " + e.getMessage());
        }
    }
}
