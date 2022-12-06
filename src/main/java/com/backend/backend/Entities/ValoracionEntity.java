package com.backend.backend.Entities;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
// Relaciones completas
@Data
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
}
