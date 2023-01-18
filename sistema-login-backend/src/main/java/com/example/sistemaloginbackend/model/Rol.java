package com.example.sistemaloginbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idRol;
    @Column(name = "rol_name")
    private String name;

    public Rol() {
    }

    public Rol(Long idRol) {
        this.idRol = idRol;
    }

    public Rol(Long idRol, String name) {
        this.idRol = idRol;
        this.name = name;
    }
}
