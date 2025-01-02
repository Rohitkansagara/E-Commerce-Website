package com.a99.service;

import com.a99.model.User;
import com.a99.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String register(User user) {
        // Add logic for registering a user, such as password encryption
        userRepository.save(user);
        return "User registered successfully";
    }

    public String login(User user) {
        User foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return "Login successful";
        }
        return "Invalid credentials";
    }
}
