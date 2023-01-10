package com.example.veterinaria.service;

import com.example.veterinaria.dto.MascotaDuenioDTO;
import com.example.veterinaria.model.Mascota;
import java.util.List;


public interface IMascotaService {

    public void saveMascota(Mascota masco);
    
    public Mascota findMascota(Long id);
    
    public List<Mascota> findAllMascota();
    
    public void deleteMascota(Long id);
    
    public void updateMascota(Mascota masco);
    
    public List<Mascota> findPerrosCaniches();
    
    public List<MascotaDuenioDTO> getDataMascotaAndDuenio(Long id);
    
}
