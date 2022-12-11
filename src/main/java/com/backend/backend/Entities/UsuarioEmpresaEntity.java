package com.backend.backend.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "empresas_favoritas")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "empresas_favoritas")
public class UsuarioEmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean favorito;
    // UsuarioEntity
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    @ToString.Exclude
    private UsuarioEntity id_usuario;
    // EmpresaEntity
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity id_empresa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuarioEmpresaEntity that = (UsuarioEmpresaEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
