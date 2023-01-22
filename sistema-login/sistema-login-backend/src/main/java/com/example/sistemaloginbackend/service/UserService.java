package com.example.sistemaloginbackend.service;


import com.example.sistemaloginbackend.model.Rol;
import com.example.sistemaloginbackend.model.User;
import com.example.sistemaloginbackend.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepo;

    @Override
    public List<User> findAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User findUser(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void editUser(User user) {
        this.saveUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
