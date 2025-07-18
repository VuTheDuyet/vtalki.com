package com.vtalki.vtalki_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtalki.vtalki_backend.entity.leadforms.LeadFormEntity;

public interface LeadFormsRepository extends JpaRepository<LeadFormEntity, String> {
    // lọc theo status
    List<LeadFormEntity> findByStatus(String status);

    // tìm theo email hoặc số điện thoại (keyword)
    Optional<LeadFormEntity> findByEmailOrPhone(String email, String phone);

}
