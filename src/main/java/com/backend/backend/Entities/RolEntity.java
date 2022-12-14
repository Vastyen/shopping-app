package com.backend.backend.Entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

// Relaciones Listas
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "rol")
@Table(name = "rol")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;
    private String nombre_rol;
    private String alias_rol;
    @JsonManagedReference(value = "rol")
    @OneToMany(mappedBy = "rol",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @ToString.Exclude
    private Set<UsuarioEntity> usuarios;
    @OneToMany(mappedBy = "rol",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            orphanRemoval = true)
    @ToString.Exclude
    private Set<PermisoEntity> permisos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RolEntity rolEntity = (RolEntity) o;
        return id != null && Objects.equals(id, rolEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
