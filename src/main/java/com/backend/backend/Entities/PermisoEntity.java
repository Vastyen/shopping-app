package com.backend.backend.Entities;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

// Relaciones Listas
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "permiso")
@Table(name = "permiso")
public class PermisoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private RolEntity rol;
    private String permiso;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PermisoEntity that = (PermisoEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
