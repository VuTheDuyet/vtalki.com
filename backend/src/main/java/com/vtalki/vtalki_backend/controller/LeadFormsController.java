package com.vtalki.vtalki_backend.controller;

import com.vtalki.vtalki_backend.entity.leadforms.LeadFormEntity;
import com.vtalki.vtalki_backend.service.LeadFormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/leadforms")
public class LeadFormsController {

    @Autowired
    private LeadFormsService leadFormsService;

    // 🟢 Lấy tất cả leadforms
    @GetMapping
    public ResponseEntity<List<LeadFormEntity>> getAllLeadForms() {
        return ResponseEntity.ok(leadFormsService.getAll());
    }

    // 🟢 Lọc theo trạng thái
    @GetMapping("/status/{status}")
    public ResponseEntity<List<LeadFormEntity>> getByStatus(@PathVariable String status) {
        return ResponseEntity.ok(leadFormsService.getByStatus(status));
    }

    // 🟢 Tìm theo email hoặc số điện thoại
    @GetMapping("/search")
    public ResponseEntity<?> findByEmailOrPhone(@RequestParam String keyword) {
        return leadFormsService.findByEmailOrPhone(keyword, keyword)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("Không tìm thấy thông tin khách hàng"));
    }

    // 🟢 Lấy theo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return leadFormsService.getById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("Không tìm thấy lead với ID: " + id));
    }

    // 🟢 Tạo mới lead
    @PostMapping
    public ResponseEntity<LeadFormEntity> create(@RequestBody LeadFormEntity leadForm) {
        return ResponseEntity.ok(leadFormsService.save(leadForm));
    }

    // 🟡 Cập nhật toàn bộ lead
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody LeadFormEntity leadForm) {
        try {
            return ResponseEntity.ok(leadFormsService.update(id, leadForm));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Lỗi khi cập nhật: " + e.getMessage());
        }
    }

    // 🟡 Cập nhật chỉ trạng thái
    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable String id, @RequestBody Map<String, String> payload) {
        try {
            String status = payload.get("status");
            LeadFormEntity updated = leadFormsService.updateStatus(id, status);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi cập nhật trạng thái: " + e.getMessage());
        }
    }

    // 🟡 Cập nhật chỉ ghi chú
    @PutMapping("/{id}/note")
    public ResponseEntity<?> updateNote(@PathVariable String id, @RequestBody Map<String, String> payload) {
        try {
            String note = payload.get("staffNote");
            LeadFormEntity updated = leadFormsService.updateNote(id, note);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi cập nhật ghi chú: " + e.getMessage());
        }
    }

    // 🔴 Xóa lead theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            leadFormsService.delete(id);
            return ResponseEntity.ok("Đã xoá lead với ID: " + id);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Xoá thất bại: " + e.getMessage());
        }
    }

    // // 🔴 Xoá hàng loạt
    // @DeleteMapping
    // public ResponseEntity<?> deleteBulk(@RequestBody List<String> ids) {
    // if (ids == null || ids.isEmpty()) {
    // return ResponseEntity.badRequest().body("Danh sách ID không được để trống");
    // }

    // try {
    // leadFormsService.deleteBulk(ids);
    // return ResponseEntity.ok("Đã xoá " + ids.size() + " lead forms");
    // } catch (Exception e) {
    // return ResponseEntity.badRequest().body("Xoá hàng loạt thất bại: " +
    // e.getMessage());
    // }
    // }

    // // 🟠 Cập nhật trạng thái hàng loạt
    // @PutMapping("/bulk-update-status")
    // public ResponseEntity<?> bulkUpdateStatus(@RequestBody BulkUpdateRequest
    // request) {
    // if (request.getIds() == null || request.getIds().isEmpty()) {
    // return ResponseEntity.badRequest().body("Danh sách ID không được để trống");
    // }

    // try {
    // leadFormsService.updateStatusBulk(request.getIds(), request.getStatus());
    // return ResponseEntity.ok("Đã cập nhật trạng thái cho " +
    // request.getIds().size() + " lead forms");
    // } catch (Exception e) {
    // return ResponseEntity.badRequest().body("Lỗi cập nhật trạng thái: " +
    // e.getMessage());
    // }
    // }
}
