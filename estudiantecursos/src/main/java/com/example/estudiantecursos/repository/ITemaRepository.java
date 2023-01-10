package com.example.estudiantecursos.repository;

import com.example.estudiantecursos.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ITemaRepository extends JpaRepository<Tema,Long>{
    
}
