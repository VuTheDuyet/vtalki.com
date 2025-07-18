package com.vtalki.vtalki_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtalki.vtalki_backend.entity.question.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, String> {

    List<QuestionEntity> findByStatus(boolean status);
}