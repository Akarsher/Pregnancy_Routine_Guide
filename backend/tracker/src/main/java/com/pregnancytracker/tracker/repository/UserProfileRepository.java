package com.pregnancytracker.tracker.repository;

import com.pregnancytracker.tracker.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
    // You can add custom queries here if needed
}
