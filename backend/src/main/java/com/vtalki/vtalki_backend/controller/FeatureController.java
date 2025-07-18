package com.vtalki.vtalki_backend.controller;

import com.vtalki.vtalki_backend.dto.BulkUpdateRequest;
import com.vtalki.vtalki_backend.entity.feature.FeatureEntity;
import com.vtalki.vtalki_backend.service.FeatureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/features")
public class FeatureController {

    private final FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @GetMapping
    public ResponseEntity<List<FeatureEntity>> getAll() {
        return ResponseEntity.ok(featureService.getAll());
    }

    @GetMapping("/active")
    public ResponseEntity<List<FeatureEntity>> getActiveFeatures() {
        return ResponseEntity.ok(featureService.getByStatus(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeatureEntity> getById(@PathVariable String id) {
        return featureService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FeatureEntity> create(@RequestBody FeatureEntity feature) {
        return ResponseEntity.ok(featureService.create(feature));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeatureEntity> update(@PathVariable String id, @RequestBody FeatureEntity feature) {
        try {
            return ResponseEntity.ok(featureService.update(id, feature));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/bulk-update-status")
    public ResponseEntity<?> updateStatusBulk(@RequestBody BulkUpdateRequest request) {
        try {
            featureService.updateStatusBulk(request.getIds(), request.getStatus());
            return ResponseEntity.ok("Đã cập nhật trạng thái cho " + request.getIds().size() + " features.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi cập nhật trạng thái: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        try {
            featureService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
