package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:4200/")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @GetMapping("/{id}")
    public Task findTask(@PathVariable Long id){
        return taskService.findTask(id);
    }

    @GetMapping("/list")
    public List<Task> findAllTasks(){
        return taskService.findAllTask();
    }

    @PostMapping("/task")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        taskService.saveTask(task);
        return new ResponseEntity<Task>(task,null, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Task> editTask(@PathVariable Long id, @RequestBody Task task){
        Task taskActual = taskService.findTask(id);

        taskActual.setName(task.getName());
        taskActual.setDescription(task.getDescription());

        Task actualizedTask = taskService.saveTask(taskActual);
        return ResponseEntity.ok(actualizedTask);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}
