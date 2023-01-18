package com.example.sistemaloginbackend.service;

import com.example.sistemaloginbackend.model.Rol;
import com.example.sistemaloginbackend.repository.IRolRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements IRolService {

    @Autowired
    private IRolRepository rolRepo;

    @Override
    public List<Rol> findAllRol() {
        return rolRepo.findAll();
    }

    @Override
    public Rol findRol(Long id) {
        return rolRepo.findById(id).orElse(null);
    }

    @Override
    public Rol saveRol(Rol rol) {

        return rolRepo.save(rol);
    }

    @Override
    public void editRol(Rol rol) {
        this.saveRol(rol);
    }

    @Override
    public void deleteRol(Long id) {
        rolRepo.deleteById(id);
    }
}
