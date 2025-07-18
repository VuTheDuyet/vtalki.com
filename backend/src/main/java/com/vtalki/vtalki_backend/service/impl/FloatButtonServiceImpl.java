package com.vtalki.vtalki_backend.service.impl;

import com.vtalki.vtalki_backend.entity.floatbutton.FloatButtonEntity;
import com.vtalki.vtalki_backend.repository.FloatButtonRepository;
import com.vtalki.vtalki_backend.service.FloatButtonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FloatButtonServiceImpl implements FloatButtonService {

    private final FloatButtonRepository repository;

    public FloatButtonServiceImpl(FloatButtonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FloatButtonEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<FloatButtonEntity> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public FloatButtonEntity create(FloatButtonEntity button) {
        return repository.save(button);
    }

    @Override
    public FloatButtonEntity update(String id, FloatButtonEntity button) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(button.getName());
                    existing.setHref(button.getHref());
                    existing.setShowFor(button.getShowFor());
                    existing.setActive(button.isActive());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Không tìm thấy FloatButton với ID: " + id));
    }

    @Override
    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Không tồn tại nút với ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<FloatButtonEntity> getByStatus(boolean status) {
        return repository.findByActive(status);
    }

    @Override
    public void updateStatusBulk(List<String> ids, boolean status) {
        List<FloatButtonEntity> buttons = repository.findAllById(ids);
        for (FloatButtonEntity btn : buttons) {
            btn.setActive(status);
        }
        repository.saveAll(buttons);
    }
}
