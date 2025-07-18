package com.vtalki.vtalki_backend.entity.popup;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "popup")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PopupEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private String id;

    @Column(name = "main_video_url", nullable = false)
    private String mainVideoUrl; // 👉 video chính, thường là video giới thiệu

    @Column(name = "popup_video_url", nullable = false)
    private String popupVideoUrl; // 👉 video hiển thị trong popup

    @Column(name = "video_about")
    private String videoAbout; // 👉 mô tả nội dung video tổng thể

    // Tiêu đề đa ngôn ngữ cho popup
    @Column(name = "title_vi")
    private String titleVi;

    @Column(name = "title_en")
    private String titleEn;

    @Column(name = "title_ko")
    private String titleKo;

    // 🆕 Mô tả trong popup đa ngôn ngữ
    @Column(name = "description_popup_vi")
    private String descriptionPopupVi;

    @Column(name = "description_popup_en")
    private String descriptionPopupEn;

    @Column(name = "description_popup_ko")
    private String descriptionPopupKo;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private Boolean status = true;
}
