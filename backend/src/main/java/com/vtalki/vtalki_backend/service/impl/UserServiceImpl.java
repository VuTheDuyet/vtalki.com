package com.vtalki.vtalki_backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vtalki.vtalki_backend.entity.user.UserEntity;
import com.vtalki.vtalki_backend.repository.UserRepository;
import com.vtalki.vtalki_backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Nếu dùng mã hóa

    @Override
    public UserEntity create(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<UserEntity> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<UserEntity> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity update(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public void updatePassword(String email, String newPassword) {
        userRepository.findByEmail(email).ifPresent(user -> {
            user.setPassword(passwordEncoder.encode(newPassword)); // Mã hóa
            userRepository.save(user);
        });
    }

    @Override
    public Optional<String> getChatLink() {
        // Vì hệ thống chỉ có 1 user duy nhất
        return userRepository.findAll().stream()
                .findFirst()
                .map(UserEntity::getChatboxLink);
    }
}
