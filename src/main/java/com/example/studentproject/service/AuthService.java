package com.example.studentproject.service;

import com.example.studentproject.dto.request.LoginRequest;
import com.example.studentproject.dto.response.LoginResponse;
import com.example.studentproject.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest request) {
        // İstifadəçini tap
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("İstifadəçi tapılmadı"));

        // Şifrəni yoxla
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Şifrə yanlışdır");
        }

        // JWT yarat və qaytar
        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
        return new LoginResponse(token, user.getUsername(), user.getRole());
    }
}
