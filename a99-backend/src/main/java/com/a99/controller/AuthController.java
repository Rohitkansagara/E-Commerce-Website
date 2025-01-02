package com.a99.controller;

import com.a99.model.User;
import com.a99.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        return authService.login(user);
    }
}
