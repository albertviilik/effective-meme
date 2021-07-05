package com.albertviilik.todoapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("task")
@Data
public class Task {
    @Id
    private String id;
    @Field("desc")
    private String description;
    @Field("status")
    private CompletionState completed;
}
