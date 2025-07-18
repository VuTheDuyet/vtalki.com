package com.vtalki.vtalki_backend.entity.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false, unique = true)
    private String username; // tài khoản đăng nhập

    @Column(nullable = false)
    private String password; // nên mã hóa bằng BCrypt

    @Column(nullable = false, unique = true)
    private String email; // dùng để gửi liên hệ hoặc đặt lại mật khẩu

    @Column
    private String chatboxLink; // VD: link Zalo, Messenger, Telegram...

    @Column
    private boolean active = true;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
