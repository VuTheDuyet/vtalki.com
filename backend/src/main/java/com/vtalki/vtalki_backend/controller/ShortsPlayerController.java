package com.vtalki.vtalki_backend.controller;

import com.vtalki.vtalki_backend.dto.BulkUpdateRequest;
import com.vtalki.vtalki_backend.entity.shortsplayer.ShortsPlayerEntity;
import com.vtalki.vtalki_backend.service.ShortsPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shorts")
public class ShortsPlayerController {

    @Autowired
    private ShortsPlayerService shortsPlayerService;

    // Lấy tất cả shorts
    @GetMapping
    public ResponseEntity<List<ShortsPlayerEntity>> getAllShorts() {
        return ResponseEntity.ok(shortsPlayerService.getAll());
    }

    // Lấy shorts đang active
    @GetMapping("/active")
    public ResponseEntity<List<ShortsPlayerEntity>> getActiveShorts() {
        return ResponseEntity.ok(shortsPlayerService.getByStatus(true));
    }

    // Tạo mới shorts
    @PostMapping
    public ResponseEntity<ShortsPlayerEntity> createShort(@RequestBody ShortsPlayerEntity shorts) {
        ShortsPlayerEntity saved = shortsPlayerService.save(shorts);
        return ResponseEntity.ok(saved);
    }

    // Lấy shorts theo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getShortById(@PathVariable String id) {
        return shortsPlayerService.getById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body("Không tìm thấy shorts với id: " + id));
    }

    // Cập nhật shorts
    @PutMapping("/{id}")
    public ResponseEntity<?> updateShort(@PathVariable String id, @RequestBody ShortsPlayerEntity updatedShort) {
        try {
            ShortsPlayerEntity updated = shortsPlayerService.update(id, updatedShort);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Không tìm thấy shorts: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi cập nhật shorts: " + e.getMessage());
        }
    }

    // Xóa shorts
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShort(@PathVariable String id) {
        try {
            shortsPlayerService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Không tìm thấy shorts để xóa: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi xóa shorts: " + e.getMessage());
        }
    }

    // Cập nhật trạng thái hàng loạt
    @PutMapping("/bulk-update-status")
    public ResponseEntity<?> updateStatusBulk(@RequestBody BulkUpdateRequest request) {
        if (request.getIds() == null || request.getIds().isEmpty()) {
            return ResponseEntity.badRequest().body("Danh sách ID không được để trống");
        }

        try {
            shortsPlayerService.updateStatusBulk(request.getIds(), request.getStatus());
            return ResponseEntity.ok("Đã cập nhật trạng thái cho " + request.getIds().size() + " shorts");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi cập nhật trạng thái: " + e.getMessage());
        }
    }
}
