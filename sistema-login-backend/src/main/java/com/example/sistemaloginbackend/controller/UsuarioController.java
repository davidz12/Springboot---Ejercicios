package com.example.sistemaloginbackend.controller;

import com.example.sistemaloginbackend.model.User;
import com.example.sistemaloginbackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200/")
public class UsuarioController {

    @Autowired
    private IUserService userServ;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userServ.saveUser(user);
    }

    @GetMapping("/list")
    public List<User> findAllUser() {
        return userServ.findAllUser();
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable Long id){
        return userServ.findUser(id);
    }

    @PutMapping("/edit")
    public void editUser(@RequestBody User user) {
        userServ.editUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userServ.deleteUser(id);
    }

}
