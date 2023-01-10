package com.example.estudiantecursos.controller;

import com.example.estudiantecursos.model.Tema;
import com.example.estudiantecursos.service.ITemaService;
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
public class TemaController {
    
    @Autowired
    private ITemaService temaServ;
    
    @GetMapping("/temas/traer/{id}")
    public Tema getTema(@PathVariable Long id_tema){
        return temaServ.getTema(id_tema);
    }
    
    @GetMapping("/temas/traer")
    public List<Tema> getTemas(){
        return temaServ.getTemas();
    }
    
    @PostMapping("/temas/crear")
    public void saveTema(@RequestBody Tema tema) {
        temaServ.saveTema(tema);
    }
    
    @PutMapping("temas/editar")
    public void editTema(@RequestBody Tema tema){
        temaServ.editTema(tema);
    }
    
    @DeleteMapping("temas/eliminar/{id_tema}")
    public void deleteTema(Long id_tema){
        temaServ.deleteTema(id_tema);
    }
}
