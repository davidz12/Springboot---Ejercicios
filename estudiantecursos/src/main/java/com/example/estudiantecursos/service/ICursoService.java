package com.example.estudiantecursos.service;

import com.example.estudiantecursos.dto.CursoTema;
import com.example.estudiantecursos.model.Curso;
import java.util.List;




public interface ICursoService {
    
    public List<Curso> getCursos();
    
    public Curso getCurso(Long id);
    
    public CursoTema getTemasOfCurso(Long id_curso);
    
    public List<Curso> getCursosJava();
    
    public void saveCurso(Curso curso);
    
    public void deleteCurso(Long id);
    
    public void editCurso(Curso curso);
    
}