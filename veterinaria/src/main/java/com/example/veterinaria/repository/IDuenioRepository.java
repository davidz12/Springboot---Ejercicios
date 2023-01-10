package com.example.veterinaria.repository;

import com.example.veterinaria.model.Dueño;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDuenioRepository extends JpaRepository<Dueño,Long>{
    
}
