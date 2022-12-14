package com.backend.backend.Entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

// Relaciones Completas
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "ubicacion_geografica")
@Table(name = "ubicacion_geografica")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UbicacionGeograficaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubicacion", nullable = false, unique = true)
    private Integer id;
    private String region;
    private String comuna;
    private String direccion;
    // UsuarioEntity
    @JsonIgnore
    @OneToOne(mappedBy = "id_ubicacion", fetch = FetchType.LAZY)
    @ToString.Exclude
    private UsuarioEntity usuario;

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
