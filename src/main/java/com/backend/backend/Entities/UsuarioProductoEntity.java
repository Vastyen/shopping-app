package com.backend.backend.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UsuarioProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity id_usuario;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoEntity id_producto;
}
