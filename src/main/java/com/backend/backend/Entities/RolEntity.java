package com.backend.backend.Entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;
// Relaciones Listas
@Data
@Entity
public class RolEntity {
    @Id
    @Column(nullable = false, unique = true)
    private Integer id;
    private String nombre_rol;
    private String alias_rol;
    @OneToMany(mappedBy = "rol",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            orphanRemoval = true)
    private Set<UsuarioEntity> usuarios;
    @OneToMany(mappedBy = "rol",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            orphanRemoval = true)
    private Set<PermisoEntity> permisos;
}
