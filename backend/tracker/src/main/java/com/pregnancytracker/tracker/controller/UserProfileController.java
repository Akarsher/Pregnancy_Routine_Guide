package com.pregnancytracker.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pregnancytracker.tracker.model.UserProfile;
import com.pregnancytracker.tracker.repository.UserProfileRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserProfileController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    // Create a new user
    @PostMapping
    public UserProfile createUser(@RequestBody UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    // Get all users
    @GetMapping
    public List<UserProfile> getAllUsers() {
        return userProfileRepository.findAll();
    }

    // Get a single user by ID
    @GetMapping("/{id}")
    public UserProfile getUserById(@PathVariable String id) {
        return userProfileRepository.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public UserProfile updateUser(
            @PathVariable String id,
            @RequestBody UserProfile updatedUser
    ) {
        return userProfileRepository.findById(id)
            .map(user -> {
                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                user.setDueDate(updatedUser.getDueDate());
                user.setPassword(updatedUser.getPassword());
                return userProfileRepository.save(user);
            })
            .orElse(null);
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        userProfileRepository.deleteById(id);
        return "User deleted successfully.";
    }
}
