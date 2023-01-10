package com.example.veterinaria.controller;

import com.example.veterinaria.dto.MascotaDuenioDTO;
import com.example.veterinaria.model.Mascota;
import com.example.veterinaria.service.IMascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {
    
    @Autowired
    private IMascotaService mascoServ;
    
    @PostMapping("/mascota/crear")
    public void saveMascota(@RequestBody Mascota masco) {
        mascoServ.saveMascota(masco);
    }

    @GetMapping("/mascota/traer/{id}")
    public Mascota findMascota(@PathVariable Long id) {
        return mascoServ.findMascota(id);
    }

    @GetMapping("/mascota/traerlas")
    public List<Mascota> findAllMascota() {
        return mascoServ.findAllMascota();
    }

    @DeleteMapping("/mascota/borrar/{id}")
    public void deleteMascota(@PathVariable Long id) {
        mascoServ.deleteMascota(id);
    }

    @PutMapping("/mascota/editar")
    public void updateMascota(@RequestBody Mascota masco) {
        this.saveMascota(masco);
    }

    @GetMapping("/mascota/traerlas/caniches")
    public List<Mascota> findPerrosCaniches() {
        return mascoServ.findPerrosCaniches();
    }

    @GetMapping("/mascota/traerlas/masco_duenio/{id}")
    public List<MascotaDuenioDTO> getDataMascotaAndDuenio(@PathVariable Long id) {
        return mascoServ.getDataMascotaAndDuenio(id);
    }
}
