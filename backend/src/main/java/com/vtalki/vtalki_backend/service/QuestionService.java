package com.vtalki.vtalki_backend.service;

import com.vtalki.vtalki_backend.entity.question.QuestionEntity;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<QuestionEntity> getAll();

    Optional<QuestionEntity> getById(String id);

    QuestionEntity save(QuestionEntity questionEntity);

    QuestionEntity update(String id, QuestionEntity questionEntity);

    void delete(String id);

    // ✅ Lọc câu hỏi theo trạng thái hiển thị (public / hidden)
    List<QuestionEntity> getByStatus(boolean status);

    // ✅ Cập nhật trạng thái nhiều câu hỏi cùng lúc
    void updateStatusBulk(List<String> ids, boolean status);
}
