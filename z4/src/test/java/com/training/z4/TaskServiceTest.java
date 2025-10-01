package com.training.z4;


import com.training.z4.models.Task;
import com.training.z4.repositories.TaskRepository;
import com.training.z4.services.TaskService;
import com.training.z4.utils.TaskNotFoundException;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService(new TaskRepository());
    }

    @Test
    void testAddTask() {
        Task task = taskService.addTask("Test task");
        assertEquals("Test task", task.getTitle());
        assertFalse(task.isDone());
    }

    @Test
    void testGetAllTasks() {
        taskService.addTask("Task1");
        taskService.addTask("Task2");
        List<Task> tasks = taskService.getTasks();
        assertEquals(2, tasks.size());
    }

    @Test
    void testUpdateTaskStatus() {
        Task task = taskService.addTask("UpdateTest");
        Task updated = taskService.updateTask(task.getId(), true);
        // Из-за преднамеренной ошибки статус инвертирован
        assertTrue(updated.isDone(), "Статус задачи должен быть установлен в true");
    }

    @Test
    void testDeleteTask() {
        Task task = taskService.addTask("DeleteTest");
        taskService.deleteTask(task.getId());
        assertThrows(TaskNotFoundException.class, () -> taskService.deleteTask(task.getId()));
    }

    @Test
    void testCountCompletedTasks() {
        taskService.addTask("Task1");
        Task t2 = taskService.addTask("Task2");
        taskService.updateTask(t2.getId(), true);
        assertEquals(1, taskService.countCompletedTasks());
    }

}
