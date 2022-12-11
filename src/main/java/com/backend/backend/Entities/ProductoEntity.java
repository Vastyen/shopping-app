package com.backend.backend.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
    @JsonBackReference
    @OneToMany(mappedBy = "id_producto",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @ToString.Exclude
    private Set<CarritoComprasProductoEntity> carritos;
    // UsuarioProductoEntity
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            mappedBy = "productos")
    @ToString.Exclude
    private Set<UsuarioEntity> usuarios;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductoEntity that = (ProductoEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
