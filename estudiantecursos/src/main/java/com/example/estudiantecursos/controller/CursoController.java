package com.example.estudiantecursos.controller;

import com.example.estudiantecursos.dto.CursoTema;
import com.example.estudiantecursos.model.Curso;
import com.example.estudiantecursos.service.ICursoService;
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
public class CursoController {
    
    @Autowired
    private ICursoService cursoServ;
    
    
    @GetMapping("/cursos/traer")
    public List<Curso> getCursos() {
        return cursoServ.getCursos();
    }
    
    @GetMapping("/cursos/traer/{id}")
    public Curso getCurso(@PathVariable Long id){
        return cursoServ.getCurso(id);
    }
    
    @GetMapping("/cursos/temas/{id}") 
    public CursoTema getTemasOfCurso(@PathVariable Long id_curso){
        return cursoServ.getTemasOfCurso(id_curso);
    }
    
    @GetMapping("cursos/traer/java")
    public List<Curso> getCursosJava(){
        return cursoServ.getCursosJava();
    }
    
    @PostMapping("cursos/crear")
    public void saveCurso(@RequestBody Curso curso) {
        cursoServ.saveCurso(curso);
    }
    
    @DeleteMapping("cursos/eliminar/{id}")
    public void deleteCurso(@PathVariable Long id) {
        cursoServ.deleteCurso(id);
    }
    
    @PutMapping("cursos/editar") 
    public void editCurso(@RequestBody Curso curso) {
        cursoServ.editCurso(curso);
    }
    
}
