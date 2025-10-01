package com.training.z4.services;


import com.training.z4.models.Task;
import com.training.z4.repositories.TaskRepository;
import com.training.z4.utils.TaskNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

   private final TaskRepository taskRepository;

   public Task addTask(String title) {
       Task task = new Task(null,title,false);
       return taskRepository.save(task);
   }

   public List<Task> getTasks() {
       return taskRepository.findAll();
   }

   public Task updateTask(Long id, boolean completed) {
       //Task task = taskRepository.findById(id);
       Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
       task.setDone(completed);
       return taskRepository.save(task);
   }
   public void deleteTask(long id) {
       if (taskRepository.findById(id).isEmpty()) throw new TaskNotFoundException(id);
       taskRepository.delete(id);
   }

   public long countCompletedTasks() {
       return taskRepository.findAll().stream().filter(Task::isDone).count();
   }

}
