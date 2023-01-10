package com.example.veterinaria.service;

import com.example.veterinaria.model.Dueño;
import com.example.veterinaria.repository.IDuenioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DuenioService implements IDuenioService{
    
    @Autowired
    private IDuenioRepository duenioRepo;

    @Override
    public void saveDuenio(@RequestBody Dueño duenio) {
        duenioRepo.save(duenio);
    }

    @Override
    public Dueño findDuenio(Long id) {
        return duenioRepo.findById(id).orElse(null);
    }

    @Override
    public List<Dueño> findAllDuenio() {
        return duenioRepo.findAll();
    }

    @Override
    public void deleteDuenio(Long id) {
        duenioRepo.deleteById(id);
    }

    @Override
    public void updateDuenio(@RequestBody Dueño duenio) {
        this.saveDuenio(duenio);
    }
    
}
