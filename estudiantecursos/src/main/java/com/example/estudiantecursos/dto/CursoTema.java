package com.example.estudiantecursos.dto;

import com.example.estudiantecursos.model.Tema;
import java.util.List;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
public class CursoTema {

    private String nombreCurso;
    private List<Tema> listaTemas;

    public CursoTema() {
    }

    public CursoTema(String nombreCurso, List<Tema> listaTemas) {
        this.nombreCurso = nombreCurso;
        this.listaTemas = listaTemas;
    }
    
    

    
}
