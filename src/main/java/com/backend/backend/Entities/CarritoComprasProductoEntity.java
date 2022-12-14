package com.backend.backend.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity(name = "carrito_compras_producto")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "carrito_compras_producto")
public class CarritoComprasProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito_producto", nullable = false, unique = true)
    private Integer id;
    private Integer cantidad;
    // CarritoComprasEntity
    @JsonBackReference(value = "carrito")
    @ManyToOne
    @JoinColumn(name = "id_carrito")
    private CarritoComprasEntity id_carrito;
    // ProductoEntity
    @JsonBackReference(value = "producto")
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoEntity id_producto;
}
