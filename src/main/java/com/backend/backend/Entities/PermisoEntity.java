package com.backend.backend.Entities;


import lombok.Data;

import javax.persistence.*;
// Relaciones Listas
@Data
@Entity
public class PermisoEntity {
    @Id
    @Column(nullable = false, unique = true)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private RolEntity rol;
    private String permiso;
}
