package com.vtalki.vtalki_backend.controller;

import com.vtalki.vtalki_backend.dto.PasswordChangeRequest;
import com.vtalki.vtalki_backend.dto.PasswordResetRequest;
import com.vtalki.vtalki_backend.entity.user.UserEntity;
import com.vtalki.vtalki_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    UserController(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // 🔹 Tạo mới (có thể bỏ nếu không cho frontend tạo user)
    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        return ResponseEntity.ok(userService.create(user));
    }

    // 🔹 Lấy tất cả user (chỉ có 1 user duy nhất)
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    // 🔹 Lấy theo username
    @GetMapping("/username/{username}")
    public ResponseEntity<UserEntity> getByUsername(@PathVariable String username) {
        return userService.getByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 Lấy theo email
    @GetMapping("/email/{email}")
    public ResponseEntity<UserEntity> getByEmail(@PathVariable String email) {
        return userService.getByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 Get link chat
    @GetMapping("/chat-link")
    public ResponseEntity<String> getChatLink() {
        return userService.getChatLink()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy link chat"));
    }

    // 🔹 Cập nhật thông tin user
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable String id, @RequestBody UserEntity updatedUser) {
        Optional<UserEntity> existingUser = userService.getAll().stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();

        if (existingUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        updatedUser.setId(id); // đảm bảo không đổi ID
        return ResponseEntity.ok(userService.update(updatedUser));
    }

    // 🔹 Cập nhật mật khẩu
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody PasswordResetRequest request) {
        Optional<UserEntity> userOpt = userService.getByEmail(request.getEmail());
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy email");
        }

        userService.updatePassword(request.getEmail(), request.getNewPassword());
        return ResponseEntity.ok("Cập nhật mật khẩu thành công");
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody PasswordChangeRequest request) {
        Optional<UserEntity> userOpt = userService.getByEmail(request.getEmail());

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("❌ Email không tồn tại");
        }

        UserEntity user = userOpt.get();
        if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("❌ Mật khẩu cũ không đúng");
        }

        userService.updatePassword(request.getEmail(), request.getNewPassword());
        return ResponseEntity.ok("✅ Đổi mật khẩu thành công");
    }

}
