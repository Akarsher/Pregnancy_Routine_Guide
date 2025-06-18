package com.pregnancytracker.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pregnancytracker.tracker.model.PregnancyTask;
import com.pregnancytracker.tracker.repository.PregnancyTaskRepository;
@RestController
@RequestMapping("/tasks")
public class PregnancyTaskController {

    @Autowired
    private PregnancyTaskRepository taskRepository;

    // Add a new task
    @PostMapping
    public PregnancyTask createTask(@RequestBody PregnancyTask task) {
        return taskRepository.save(task);
    }

    // Get all tasks
    @GetMapping
    public List<PregnancyTask> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get tasks for a specific user
    @GetMapping("/user/{userId}")
    public List<PregnancyTask> getTasksByUser(@PathVariable String userId) {
        return taskRepository.findByUserId(userId);
    }

    // Get tasks for a specific user by week
    @GetMapping("/user/{userId}/week/{week}")
    public List<PregnancyTask> getTasksByUserAndWeek(@PathVariable String userId, @PathVariable int week) {
        return taskRepository.findByUserIdAndWeek(userId, week);
    }

    // Mark a task as completed
    @PutMapping("/{id}/complete")
    public String completeTask(@PathVariable String id) {
        PregnancyTask task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setCompleted(true);
            taskRepository.save(task);
            return "Task marked as completed.";
        }
        return "Task not found.";
    }

@PutMapping("/{id}")
public PregnancyTask updateTask(@PathVariable String id, @RequestBody PregnancyTask updatedTask) {
    PregnancyTask task = taskRepository.findById(id).orElse(null);
    if (task != null) {
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setWeek(updatedTask.getWeek());
        task.setCompleted(updatedTask.isCompleted());
        task.setUserId(updatedTask.getUserId());
        return taskRepository.save(task);
    }
    return null;
}

    // Delete a task
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable String id) {
        taskRepository.deleteById(id);
        return "Task deleted successfully.";
    }
}
