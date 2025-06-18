package com.pregnancytracker.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pregnancytracker.tracker.model.UserProfile;
import com.pregnancytracker.tracker.repository.UserProfileRepository;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    // Signup (register)
    @PostMapping("/signup")
    public UserProfile signup(@RequestBody UserProfile user) {
        // Ideally, check if email already exists before saving
        return userProfileRepository.save(user);
    }

    // Login
    @PostMapping("/login")
    public UserProfile login(@RequestBody UserProfile user) {
        UserProfile foundUser = userProfileRepository.findAll()
            .stream()
            .filter(u -> u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword()))
            .findFirst()
            .orElse(null);

        if (foundUser == null) {
            // In real apps return 401 Unauthorized or error response
            return null;
        }
        // For micro project, just return user data (no token)
        return foundUser;
    }
}
