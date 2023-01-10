package com.example.estudiantecursos.service;

import com.example.estudiantecursos.model.Tema;
import com.example.estudiantecursos.repository.ITemaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService implements ITemaService{
    
    @Autowired
    private ITemaRepository temaRepo;

    @Override
    public Tema getTema(Long id_tema) {
        return temaRepo.findById(id_tema).orElse(null);
    }

    @Override
    public List<Tema> getTemas() {
        return temaRepo.findAll();
    }

    @Override
    public void saveTema(Tema tema) {
        temaRepo.save(tema);
    }

    @Override
    public void editTema(Tema tema) {
        this.saveTema(tema);
    }

    @Override
    public void deleteTema(Long id_tema) {
        temaRepo.deleteById(id_tema);
    }
    
    
    
}
