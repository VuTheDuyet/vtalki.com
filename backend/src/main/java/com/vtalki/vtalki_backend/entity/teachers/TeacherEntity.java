package com.vtalki.vtalki_backend.entity.teachers;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teachers")
@EntityListeners(AuditingEntityListener.class) // để createdAt, updatedAt hoạt động
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private String id; // Bạn cần tự generate id hoặc dùng UUID

    @Column(nullable = false)
    private String name;

    private String avatarUrl;

    @JsonFormat(pattern = "yyyy-MM-dd") // 👈 fix lỗi parse JSON
    private LocalDate dob;
    private String gender;
    private String birthplace;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    private double rating;
    private int reviewsCount;

    private String languagesSpoken;

    @Column(columnDefinition = "TEXT")
    private String bioVi;
    @Column(columnDefinition = "TEXT")
    private String bioEn;
    @Column(columnDefinition = "TEXT")
    private String bioKo;

    @Column(columnDefinition = "TEXT")
    private String teachingIntroVi;
    @Column(columnDefinition = "TEXT")
    private String teachingIntroEn;
    @Column(columnDefinition = "TEXT")
    private String teachingIntroKo;

    @Column(columnDefinition = "TEXT")
    private String certificates;

    @Column(columnDefinition = "TEXT")
    private String experience;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}