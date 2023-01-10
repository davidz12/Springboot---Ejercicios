package com.example.veterinaria.service;

import com.example.veterinaria.model.Dueño;
import java.util.List;


public interface IDuenioService {
    
    public void saveDuenio(Dueño duenio);
    
    public Dueño findDuenio(Long id);
    
    public List<Dueño> findAllDuenio();
    
    public void deleteDuenio(Long id);
    
    public void updateDuenio(Dueño duenio);
    
}
