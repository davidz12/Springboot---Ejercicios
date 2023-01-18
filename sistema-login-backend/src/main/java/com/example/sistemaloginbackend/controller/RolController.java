package com.example.sistemaloginbackend.controller;

import com.example.sistemaloginbackend.model.Rol;
import com.example.sistemaloginbackend.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private IRolService rolServ;

    @GetMapping("/rols")
    public List<Rol> findAllRol(){
        return rolServ.findAllRol();
    }

    @GetMapping("/{id}")
    public Rol findRol(@PathVariable Long id){
        return rolServ.findRol(id);
    }

    @PostMapping("/")
    public Rol saveRol(@RequestBody Rol rol){
       return rolServ.saveRol(rol);
    }

    @PutMapping("/edit")
    public void editRol(@RequestBody Rol rol){
        rolServ.editRol(rol);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRol(@PathVariable Long id){
        rolServ.deleteRol(id);
    }
}
