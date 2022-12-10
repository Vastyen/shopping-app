package com.backend.backend.Entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

// Relaciones completas
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class ValoracionEntity {
    @Id
    @Column(nullable = false, unique = true)
    private Integer id_valoracion;
    private String nombre_empresa;
    private Integer estrellas;
    private String comentario;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity id_usuario;
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity id_empresa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ValoracionEntity that = (ValoracionEntity) o;
        return id_valoracion != null && Objects.equals(id_valoracion, that.id_valoracion);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
