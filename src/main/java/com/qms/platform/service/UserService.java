package com.qms.platform.service;

import com.qms.platform.dto.LoginRequest;
import com.qms.platform.dto.LoginResponse;
import com.qms.platform.dto.RegisterRequest;
import com.qms.platform.entity.UserEntity;
import com.qms.platform.repository.UserRepository;
import com.qms.platform.security.JwtTokenProvider;

import lombok.AllArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;
    private PasswordEncoder passwordEncoder;

    @Transactional
    public LoginResponse register(RegisterRequest request) {
        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setDisplayName(request.getDisplayName());
        user.setRoleCode(request.getRoleCode());
        user.setDepartmentCode(request.getDepartmentCode());
        userRepository.save(user);

        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoleCode(), user.getDepartmentCode());
        return new LoginResponse(token, user.getUsername(), user.getRoleCode(), user.getDepartmentCode());
    }

    public LoginResponse login(LoginRequest request) {
        UserEntity user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid username or password");
        }

        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoleCode(), user.getDepartmentCode());
        return new LoginResponse(token, user.getUsername(), user.getRoleCode(), user.getDepartmentCode());
    }
}
