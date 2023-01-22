package com.example.sistemaloginbackend.service;

import com.example.sistemaloginbackend.model.Rol;

import java.util.List;

public interface IRolService {

    public List<Rol> findAllRol();

    public Rol findRol(Long id);

    public Rol saveRol(Rol rol);

    public void editRol(Rol rol);

    public void deleteRol(Long id);

}
