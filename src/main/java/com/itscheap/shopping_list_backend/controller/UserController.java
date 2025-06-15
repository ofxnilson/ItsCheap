package com.itscheap.shopping_list_backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itscheap.shopping_list_backend.model.User;
import com.itscheap.shopping_list_backend.repository.UserRepository;

@RestController
@RequestMapping("/api/users") // All user endpoints start with /api/users
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // ========== Registration ==========
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        // Check if username is already taken
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists!");
        }

        // Password validation (at least 8 chars, 1 letter, 1 symbol)
        String pw = user.getPassword();
        if (pw.length() < 8 || !pw.matches(".*[A-Za-z].*") || !pw.matches(".*[^A-Za-z0-9].*")) {
            return ResponseEntity.badRequest().body(
                "Password must be at least 8 characters long, contain a letter and a symbol.");
        }

        // **In production, hash password!**
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    // ========== Login ==========
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginUser) {
        Optional<User> userOpt = userRepository.findByUsername(loginUser.getUsername());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // In production: check hashed password
            if (user.getPassword().equals(loginUser.getPassword())) {
                return ResponseEntity.ok("Login successful!");
            }
        }
        return ResponseEntity.status(401).body("Invalid username or password.");
    }
}
