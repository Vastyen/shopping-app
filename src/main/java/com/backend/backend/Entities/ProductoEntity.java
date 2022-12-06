package com.backend.backend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;


@Data
@Entity
public class ProductoEntity {
    @Id
    @Column(name = "id_producto", nullable = false, unique = true)
    private Integer id;
    private String nombre_producto;
    private String descripcion;
    private String tipo;
    private Float precio;
    private Integer stock;
    private Integer ventas_producto;
    // ProductoCarritoEntity
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            mappedBy = "productos")
    private Set<CarritoComprasEntity> carritosCompra;
    // UsuarioProductoEntity
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            mappedBy = "productos")
    private Set<UsuarioEntity> usuarios;
}
