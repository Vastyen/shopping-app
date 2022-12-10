package com.backend.backend.Entities;

import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class CarritoComprasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito", nullable = false, unique = true)
    private Integer id;
    // UsuarioEntity
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity id_usuario;
    // ProductoCarritoEntity
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "carrito_productos",
            joinColumns = {@JoinColumn(name = "id_carrito")},
            inverseJoinColumns = {@JoinColumn(name = "id_producto")})
    private Set<ProductoEntity> productos = new HashSet<>();
}
