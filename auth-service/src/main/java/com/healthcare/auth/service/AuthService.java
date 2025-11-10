package com.healthcare.auth.service;

import com.healthcare.auth.model.User;
import com.healthcare.auth.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> validateUser(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password));
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
