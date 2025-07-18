package com.vtalki.vtalki_backend.entity.courses;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "coursehome")
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
public class CourseHomeEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private String id;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private Long originalPrice;

    @Column(nullable = false)
    private Long discountedPrice;

    @Column(nullable = false)
    private String languageVi;

    @Column(nullable = false)
    private String languageEn;

    @Column(nullable = false)
    private String languageKo;

    @Column(nullable = false)
    private String descriptionVi;

    @Column(nullable = false)
    private String descriptionEn;

    @Column(nullable = false)
    private String descriptionKo;

    @Column(nullable = false)
    private String levelsVi;

    @Column(nullable = false)
    private String levelsEn;

    @Column(nullable = false)
    private String levelsKo;
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @Column(nullable = false)
    private boolean status;
}