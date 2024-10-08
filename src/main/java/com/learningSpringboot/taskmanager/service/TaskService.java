package com.learningSpringboot.taskmanager.service;

import com.learningSpringboot.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;

@Repository
public class TaskService {
    private ArrayList<TaskEntity> task = new ArrayList<>();
    private int taskId = 1;

    public TaskEntity addTask(String title, String description, String deadline) {
        TaskEntity newTask = new TaskEntity(); // create a new object and add the required fields.
        newTask.setId(taskId);
        newTask.setTitle(title);
        newTask.setDescription(description);
        //newTask.setDeadline(new Date(deadline)); // TODO: Validate the date format
        newTask.setCompleted(false);
        task.add(newTask);
        taskId++;
        return newTask;
    }

    public ArrayList<TaskEntity> getAllTasks() {
        return task;
    }

    public TaskEntity getTaskById(int id) {
        for (TaskEntity tasks : task) {
            if (tasks.getId() == id) {
                return tasks;
            }
        }
        return null;
    }
}
