package com.vtalki.vtalki_backend.entity.courses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CoursesEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "course_id", updatable = false, nullable = false)
    private String courseId;

    // Language
    @Column(name = "language_key")
    private String languageKey;
    @Column(name = "language_vi")
    private String languageVi;
    @Column(name = "language_en")
    private String languageEn;
    @Column(name = "language_ko")
    private String languageKo;

    // Course Type
    @Column(name = "course_type_key")
    private String courseTypeKey;
    @Column(name = "course_type_vi")
    private String courseTypeVi;
    @Column(name = "course_type_en")
    private String courseTypeEn;
    @Column(name = "course_type_ko")
    private String courseTypeKo;

    // Format
    @Column(name = "format_key")
    private String formatKey;
    @Column(name = "format_vi")
    private String formatVi;
    @Column(name = "format_en")
    private String formatEn;
    @Column(name = "format_ko")
    private String formatKo;

    // Location
    @Column(name = "location_key")
    private String locationKey;
    @Column(name = "location_vi")
    private String locationVi;
    @Column(name = "location_en")
    private String locationEn;
    @Column(name = "location_ko")
    private String locationKo;

    // Duration
    @Column(name = "duration_key")
    private String durationKey;
    @Column(name = "duration_vi")
    private String durationVi;
    @Column(name = "duration_en")
    private String durationEn;
    @Column(name = "duration_ko")
    private String durationKo;

    // Pricing
    @Column(name = "original_fee")
    private long originalFee;

    @Column(name = "discounted_fee")
    private long discountedFee;

    @Column(name = "offer_expiry")
    private LocalDate offerExpiry;

    @Column(name = "voucher")
    private long voucher;

    // Metadata
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(nullable = false)
    private boolean status = true;
}
