package com.example.estudiantecursos.service;

import com.example.estudiantecursos.model.Tema;
import java.util.List;

public interface ITemaService {

    public Tema getTema(Long id_tema);
    
    public List<Tema> getTemas();
    
    public void saveTema(Tema tema);
    
    public void editTema(Tema tema);
    
    public void deleteTema(Long id_tema);
    
    
    
    
}
