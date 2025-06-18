package com.pregnancytracker.tracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class PregnancyTask {

    @Id
    private String id;
    private String userId;       // Link to UserProfile
    private String title;        // Task title
    private String description;  // Task details
    private int week;            // Pregnancy week number
    private boolean completed;   // Task completion status

    // Constructors
    public PregnancyTask() {}

    public PregnancyTask(String userId, String title, String description, int week, boolean completed) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.week = week;
        this.completed = completed;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
