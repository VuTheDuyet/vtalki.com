package com.vtalki.vtalki_backend.service.impl;

import com.vtalki.vtalki_backend.entity.leadforms.LeadFormEntity;
import com.vtalki.vtalki_backend.repository.LeadFormsRepository;
import com.vtalki.vtalki_backend.service.LeadFormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadFormsServiceImpl implements LeadFormsService {

    @Autowired
    private LeadFormsRepository leadFormsRepository;

    @Override
    public List<LeadFormEntity> getAll() {
        return leadFormsRepository.findAll();
    }

    @Override
    public Optional<LeadFormEntity> getById(String id) {
        return leadFormsRepository.findById(id);
    }

    @Override
    public LeadFormEntity save(LeadFormEntity leadForm) {
        return leadFormsRepository.save(leadForm);
    }

    @Override
    public LeadFormEntity update(String id, LeadFormEntity updated) {
        LeadFormEntity entity = leadFormsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy lead với ID: " + id));

        entity.setName(updated.getName());
        entity.setEmail(updated.getEmail());
        entity.setPhone(updated.getPhone());
        entity.setCourse(updated.getCourse());
        entity.setStatus(updated.getStatus());
        entity.setCustomerQuestion(updated.getCustomerQuestion());
        entity.setStaffNote(updated.getStaffNote());

        return leadFormsRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        if (!leadFormsRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy lead để xoá với ID: " + id);
        }
        leadFormsRepository.deleteById(id);
    }

    @Override
    public List<LeadFormEntity> getByStatus(String status) {
        return leadFormsRepository.findByStatus(status);
    }

    @Override
    public void updateStatusBulk(List<String> ids, String status) {
        List<LeadFormEntity> leads = leadFormsRepository.findAllById(ids);
        for (LeadFormEntity lead : leads) {
            lead.setStatus(status);
        }
        leadFormsRepository.saveAll(leads);
    }

    @Override
    public Optional<LeadFormEntity> findByEmailOrPhone(String email, String phone) {
        return leadFormsRepository.findByEmailOrPhone(email, phone);
    }

    @Override
    public LeadFormEntity updateNote(String id, String staffNote) {
        LeadFormEntity entity = leadFormsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy lead với ID: " + id));
        entity.setStaffNote(staffNote);
        return leadFormsRepository.save(entity);
    }

    @Override
    public LeadFormEntity updateStatus(String id, String status) {
        LeadFormEntity entity = leadFormsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy lead với ID: " + id));
        entity.setStatus(status);
        return leadFormsRepository.save(entity);
    }

    @Override
    public void deleteBulk(List<String> ids) {
        List<LeadFormEntity> leads = leadFormsRepository.findAllById(ids);
        leadFormsRepository.deleteAll(leads);
    }
}
