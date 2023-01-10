package com.example.estudiantecursos.service;

import com.example.estudiantecursos.dto.CursoTema;
import com.example.estudiantecursos.model.Curso;
import com.example.estudiantecursos.repository.ICursoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CursoService implements ICursoService{
    
    @Autowired
    private ICursoRepository cursoRepo;

    @Override
    public List<Curso> getCursos() {
        return cursoRepo.findAll();
    }

    @Override
    public Curso getCurso(Long id) {
        return cursoRepo.findById(id).orElse(null);
    }

    @Override
    public CursoTema getTemasOfCurso(Long id_curso) {
        //Creo el temas curso
        CursoTema temasCurso = new CursoTema();
        //Creamos el curso, a traves del findeCurso(id)
        Curso curso = this.getCurso(id_curso);
        //seteamos valores al temas curso, a traves del curso
        temasCurso.setNombreCurso(curso.getNombre());
        temasCurso.setListaTemas(curso.getListaTemas());
        
        return temasCurso;
    }

    @Override
    public List<Curso> getCursosJava() {
        
        List<Curso> cursos;
        cursos = this.getCursos();
        
        List<Curso> cursosJava = new ArrayList<>();
        
        for(Curso curso : cursos) {
            if (curso.getNombre().contains("java")){
                cursosJava.add(curso);
            }
        }
        return cursosJava;
        
    }

    @Override
    public void saveCurso(Curso curso) {
        cursoRepo.save(curso);
    }

    @Override
    public void deleteCurso(Long id) {
        cursoRepo.deleteById(id);
    }

    @Override
    public void editCurso(Curso curso) {
        this.saveCurso(curso);
    }
    
}
