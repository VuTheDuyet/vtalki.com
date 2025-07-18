package com.vtalki.vtalki_backend.controller;

import com.vtalki.vtalki_backend.entity.setting.SettingEntity;
import com.vtalki.vtalki_backend.service.SettingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/settings")
public class SettingController {

    private final SettingService settingService;

    public SettingController(SettingService settingService) {
        this.settingService = settingService;
    }

    @GetMapping
    public ResponseEntity<List<SettingEntity>> getAll() {
        return ResponseEntity.ok(settingService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SettingEntity> getById(@PathVariable String id) {
        return settingService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SettingEntity> create(@RequestBody SettingEntity setting) {
        return ResponseEntity.ok(settingService.create(setting));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SettingEntity> update(@PathVariable String id, @RequestBody SettingEntity setting) {
        try {
            return ResponseEntity.ok(settingService.update(id, setting));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        try {
            settingService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
