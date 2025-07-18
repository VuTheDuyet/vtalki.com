package com.vtalki.vtalki_backend.controller;

import com.vtalki.vtalki_backend.dto.LoginRequest;
import com.vtalki.vtalki_backend.dto.LoginResponse;
import com.vtalki.vtalki_backend.entity.user.UserEntity;
import com.vtalki.vtalki_backend.service.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<UserEntity> optionalUser = userService.getByEmail(loginRequest.getEmail());

        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                LoginResponse response = new LoginResponse(user.getEmail(), user.getChatboxLink(), user.getPassword());
                return ResponseEntity.ok(response);
            }
        }

        return ResponseEntity.status(401).body("Email hoặc mật khẩu không đúng");
    }

}
