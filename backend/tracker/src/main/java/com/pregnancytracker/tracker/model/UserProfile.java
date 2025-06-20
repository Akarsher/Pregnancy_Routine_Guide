package com.pregnancytracker.tracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserProfile {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String dueDate;  // Format: YYYY-MM-DD

    // Constructors
    public UserProfile() {}

    public UserProfile(String name, String email, String password,String dueDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dueDate = dueDate;

    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}