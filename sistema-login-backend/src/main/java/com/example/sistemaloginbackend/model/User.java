package com.example.sistemaloginbackend.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="username")
    private String user;
    @Column(name = "password_user")
    private String password;
    private String email;
    private String name;
    private boolean enabled;
    private String lastName;

    @OneToOne
    @JoinColumn(name="id_rol", referencedColumnName = "idRol", unique = true)
    private Rol rol;

    public User() {
    }

    public User(Long id, String user, String password, String email, String name, boolean enabled, String lastName, Rol rol) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.email = email;
        this.name = name;
        this.enabled = enabled;
        this.lastName = lastName;
        this.rol = rol;
    }
}
