package com.example.veterinaria.service;

import com.example.veterinaria.dto.MascotaDuenioDTO;
import com.example.veterinaria.model.Mascota;
import com.example.veterinaria.repository.IMascotaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class MascotaService implements IMascotaService{
    
    @Autowired
    private IMascotaRepository mascoRepo;

    @Override
    public void saveMascota(@RequestBody Mascota masco) {
        mascoRepo.save(masco);
    }

    @Override
    public Mascota findMascota(Long id) {
        return mascoRepo.findById(id).orElse(null);
    }

    @Override
    public List<Mascota> findAllMascota() {
        return mascoRepo.findAll();
    }

    @Override
    public void deleteMascota(Long id) {
        mascoRepo.deleteById(id);
    }

    @Override
    public void updateMascota(@RequestBody Mascota masco) {
        this.saveMascota(masco);
    }

    @Override
    public List<Mascota> findPerrosCaniches() {
        List<Mascota> listaMascotas = this.findAllMascota();
        List<Mascota> listaPerrosCaniches = new ArrayList<>();
        
        for(Mascota masco : listaMascotas){
            if(masco.getEspecie().contains("perro") && masco.getRaza().contains("canicje")){
                listaPerrosCaniches.add(masco);
            }
        }
        return listaPerrosCaniches;
    }

    @Override
    public List<MascotaDuenioDTO> getDataMascotaAndDuenio(Long id) {
        List<Mascota> listaMascotas = this.findAllMascota();
        List<MascotaDuenioDTO> listaMascoDuenio = new ArrayList<MascotaDuenioDTO>();
        
        MascotaDuenioDTO masco_duenio = new MascotaDuenioDTO();
        
        for(Mascota masco : listaMascotas){
            masco_duenio.setNombre_duenio(masco.getUnDuenio().getNombre());
            masco_duenio.setApellido_duenio(masco.getUnDuenio().getApellido());
            masco_duenio.setEspecie(masco.getEspecie());
            masco_duenio.setRaza(masco.getRaza());
            masco_duenio.setNombre_mascota(masco.getNombre());
            
            listaMascoDuenio.add(masco_duenio);
            masco_duenio = new MascotaDuenioDTO();
        }
        
        return listaMascoDuenio;
    }
    
}
