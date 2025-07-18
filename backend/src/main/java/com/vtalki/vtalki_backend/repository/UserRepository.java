package com.vtalki.vtalki_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtalki.vtalki_backend.entity.user.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);
}