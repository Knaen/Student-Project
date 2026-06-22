package com.example.studentproject.repository;

import com.example.studentproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// UserRepository.java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Username ilə tap
    Optional<User> findByUsername(String username);

    // Email ilə tap
    Optional<User> findByEmail(String email);

    // Username mövcuddur?
    boolean existsByUsername(String username);

    // Email mövcuddur?
    boolean existsByEmail(String email);

    // Rola görə tap
    List<User> findByRole(String role);
}
