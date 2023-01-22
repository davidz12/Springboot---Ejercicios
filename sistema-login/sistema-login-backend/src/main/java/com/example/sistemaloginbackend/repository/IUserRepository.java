package com.example.sistemaloginbackend.repository;

import com.example.sistemaloginbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {

}
