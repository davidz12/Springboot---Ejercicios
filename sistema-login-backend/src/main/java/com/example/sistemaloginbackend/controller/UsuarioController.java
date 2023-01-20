package com.example.sistemaloginbackend.controller;

import com.example.sistemaloginbackend.model.User;
import com.example.sistemaloginbackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200/")
public class UsuarioController {

    @Autowired
    private IUserService userServ;

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        userServ.saveUser(user);
        return new ResponseEntity<User>(user,null, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<User> findAllUser() {
        return userServ.findAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUser(@PathVariable Long id){
        User user = userServ.findUser(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> editUser(@PathVariable Long id, @RequestBody User user) {
        User userActual = userServ.findUser(id);
        userActual.setUser(user.getUser());
        userActual.setName(user.getName());
        userActual.setEmail(user.getEmail());
        userActual.setPassword(user.getPassword());
        userActual.setLastName(user.getLastName());

        User ActualizedUser = userServ.saveUser(userActual);
        return ResponseEntity.ok(ActualizedUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userServ.deleteUser(id);
    }

}
