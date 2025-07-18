package com.vtalki.vtalki_backend.service;

import java.util.List;
import java.util.Optional;

import com.vtalki.vtalki_backend.entity.user.UserEntity;

public interface UserService {
    UserEntity create(UserEntity user);

    Optional<UserEntity> getByUsername(String username);

    Optional<UserEntity> getByEmail(String email); // 🔑 dùng khi quên mật khẩu

    List<UserEntity> getAll();

    UserEntity update(UserEntity user); // 🛠 cho phép sửa thông tin (gửi OTP xong mới gọi)

    void updatePassword(String email, String newPassword); // 🔐 đổi mật khẩu mới

    Optional<String> getChatLink();
}
