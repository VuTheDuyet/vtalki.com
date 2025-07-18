package com.vtalki.vtalki_backend.service.impl;

import com.vtalki.vtalki_backend.entity.question.QuestionEntity;
import com.vtalki.vtalki_backend.repository.QuestionRepository;
import com.vtalki.vtalki_backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<QuestionEntity> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<QuestionEntity> getById(String id) {
        return questionRepository.findById(id);
    }

    @Override
    public QuestionEntity save(QuestionEntity questionEntity) {
        return questionRepository.save(questionEntity);
    }

    @Override
    public QuestionEntity update(String id, QuestionEntity updated) {
        QuestionEntity question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy câu hỏi với ID: " + id));

        question.setTranslationVi(updated.getTranslationVi());
        question.setTranslationEn(updated.getTranslationEn());
        question.setTranslationKo(updated.getTranslationKo());

        question.setAnswerVi(updated.getAnswerVi());
        question.setAnswerEn(updated.getAnswerEn());
        question.setAnswerKo(updated.getAnswerKo());

        question.setStatus(updated.getStatus());

        return questionRepository.save(question);
    }

    @Override
    public void delete(String id) {
        if (!questionRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy câu hỏi để xóa với ID: " + id);
        }
        questionRepository.deleteById(id);
    }

    @Override
    public List<QuestionEntity> getByStatus(boolean status) {
        return questionRepository.findByStatus(status);
    }

    @Override
    @Transactional
    public void updateStatusBulk(List<String> ids, boolean status) {
        List<QuestionEntity> questions = questionRepository.findAllById(ids);
        for (QuestionEntity q : questions) {
            q.setStatus(status);
        }
        questionRepository.saveAll(questions);
    }

}
