package com.training.z4.utils;

public class TaskNotFoundException extends  RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Task not found with id: " + id);
    }

}
