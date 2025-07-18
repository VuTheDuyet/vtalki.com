package com.vtalki.vtalki_backend.service;

import com.vtalki.vtalki_backend.entity.leadforms.LeadFormEntity;

import java.util.List;
import java.util.Optional;

public interface LeadFormsService {

    List<LeadFormEntity> getAll();

    Optional<LeadFormEntity> getById(String id);

    LeadFormEntity save(LeadFormEntity leadForm);

    LeadFormEntity update(String id, LeadFormEntity leadForm);

    void delete(String id);

    // ✅ Lọc theo trạng thái đã xử lý / chưa xử lý (ví dụ "đã gọi điện", "chưa liên
    // hệ")
    List<LeadFormEntity> getByStatus(String status);

    // ✅ Cập nhật trạng thái hàng loạt (ví dụ đánh dấu nhiều form là "đã xử lý")
    void updateStatusBulk(List<String> ids, String status);

    // ✅ Lấy theo email hoặc số điện thoại nếu cần lọc nhanh
    Optional<LeadFormEntity> findByEmailOrPhone(String email, String phone);

    LeadFormEntity updateNote(String id, String staffNote);

    LeadFormEntity updateStatus(String id, String status);

    void deleteBulk(List<String> ids);
}
