package com.pregnancytracker.tracker.repository;

import com.pregnancytracker.tracker.model.PregnancyTask;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PregnancyTaskRepository extends MongoRepository<PregnancyTask, String> {
    // Get all tasks by user ID
    List<PregnancyTask> findByUserId(String userId);

    // Get tasks by user ID and week
    List<PregnancyTask> findByUserIdAndWeek(String userId, int week);
}
