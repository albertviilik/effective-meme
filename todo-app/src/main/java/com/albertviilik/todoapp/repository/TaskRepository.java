package com.albertviilik.todoapp.repository;

import com.albertviilik.todoapp.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface TaskRepository extends MongoRepository<Task, String> {
    @Query("{'desc': ?0}")
    Optional<Task> findByDescription(String description);
}
