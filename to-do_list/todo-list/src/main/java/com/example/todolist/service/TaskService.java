package com.example.todolist.service;


import com.example.todolist.model.Task;
import com.example.todolist.repository.ITaskRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private ITaskRepository taskRepo;

    @Override
    public Task findTask(Long id) {
        return taskRepo.findById(id)
                .orElseThrow( () -> new EntityExistsException("La tarea con id " + id + " no existe"));
    }

    @Override
    public List<Task> findAllTask() {
        return taskRepo.findAll();
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public Task editTask(Long id, Task taskActual) {
        return this.saveTask(taskActual);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
}
