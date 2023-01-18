package com.example.sistemaloginbackend;

import com.example.sistemaloginbackend.model.Rol;
import com.example.sistemaloginbackend.model.User;
import com.example.sistemaloginbackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaLoginBackendApplication{

	public static void main(String[] args) {
		SpringApplication.run(SistemaLoginBackendApplication.class, args);
	}

}
