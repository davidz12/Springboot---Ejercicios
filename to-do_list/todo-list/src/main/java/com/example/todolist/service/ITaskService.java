package com.example.todolist.service;

import com.example.todolist.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITaskService{

    public Task findTask(Long id);

    public List<Task> findAllTask();

    public Task saveTask(Task task);

    public Task editTask(Long id, Task taskActual);

    public void deleteTask(Long id);

}
