package com.healthcare.auth.controller;

import com.healthcare.auth.model.User;
import com.healthcare.auth.service.AuthService;
import com.healthcare.gateway.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return authService.validateUser(user.getUsername(), user.getPassword())
                .map(u -> jwtUtil.generateToken(u.getUsername()))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
