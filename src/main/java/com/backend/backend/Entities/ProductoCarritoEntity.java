package com.backend.backend.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductoCarritoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private UsuarioEntity id_producto;
    @ManyToOne
    @JoinColumn(name = "id_carrito")
    private ProductoEntity id_carrito;
}
