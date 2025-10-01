package com.training.z4.repositories;

import com.training.z4.models.Task;
import com.training.z4.utils.TaskNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class TaskRepository {

    private final Map<Long, Task> tasks = new HashMap<>();

    private long nextId = 1;

    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(nextId++);
        }
        tasks.put(task.getId(), task);
        return task;
    }

    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(tasks.get(id));
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    public void delete(Long id) {
        tasks.remove(id);
    }


}
