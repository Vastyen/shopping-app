package com.backend.backend.Entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

// Relaciones Completas
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class UbicacionGeograficaEntity {
    @Id
    @Column(name = "id_ubicacion", nullable = false, unique = true)
    private Integer id;
    private String region;
    private String comuna;
    private String direccion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UbicacionGeograficaEntity that = (UbicacionGeograficaEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
