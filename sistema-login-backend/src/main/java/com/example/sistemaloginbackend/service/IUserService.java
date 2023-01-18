package com.example.sistemaloginbackend.service;

import com.example.sistemaloginbackend.model.Rol;
import com.example.sistemaloginbackend.model.User;

import java.util.List;

public interface IUserService {

    public List<User> findAllUser();

    public User findUser(Long id);

    public User saveUser(User user);


    public void editUser(User user);

    public void deleteUser(Long id);

}
