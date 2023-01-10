package com.example.veterinaria.controller;

import com.example.veterinaria.model.Dueño;
import com.example.veterinaria.service.IDuenioService;
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
public class DuenioController {
    
    @Autowired
    private IDuenioService duenioServ;
    
    @PostMapping("/duenio/crear")
    public void saveDuenio(@RequestBody Dueño duenio) {
        duenioServ.saveDuenio(duenio);
    }

    
    @GetMapping("/duenio/traer/{id}")
    public Dueño findDuenio(@PathVariable Long id) {
        return duenioServ.findDuenio(id);
    }

   @GetMapping("/duenio/traerlos")
    public List<Dueño> findAllDuenio() {
        return duenioServ.findAllDuenio();
    }

    @DeleteMapping("/duenio/borrar/{id}")
    public void deleteDuenio(@PathVariable Long id) {
        duenioServ.deleteDuenio(id);
    }

    @PutMapping("/duenio/editar")
    public void updateDuenio(@RequestBody Dueño duenio) {
        this.saveDuenio(duenio);
    }
    
}
