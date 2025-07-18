package com.vtalki.vtalki_backend.controller;

import com.vtalki.vtalki_backend.entity.popup.PopupEntity;
import com.vtalki.vtalki_backend.service.PopupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/popups")
public class PopupController {

    @Autowired
    private PopupService popupService;

    @GetMapping
    public List<PopupEntity> getAll() {
        return popupService.getAll();
    }

    @GetMapping("/{id}")
    public PopupEntity getById(@PathVariable String id) {
        return popupService.getById(id);
    }

    @PostMapping
    public PopupEntity create(@RequestBody PopupEntity popup) {
        return popupService.create(popup);
    }

    @PutMapping("/{id}")
    public PopupEntity update(@PathVariable String id, @RequestBody PopupEntity popup) {
        return popupService.update(id, popup);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        popupService.delete(id);
    }
}