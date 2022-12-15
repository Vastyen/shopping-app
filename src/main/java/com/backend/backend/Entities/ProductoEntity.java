package com.backend.backend.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "producto")
@Table(name = "producto")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false, unique = true)
    private Integer id;
    private String nombre_producto;
    private String descripcion;
    private String tipo;
    private Float precio;
    private Integer stock;
    private Integer ventas_producto;
    // ProductoCarritoEntity
    @JsonManagedReference(value = "producto")
    @OneToMany(mappedBy = "id_producto",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @ToString.Exclude
    private Set<CarritoComprasProductoEntity> carritos;
    // EmpresaEntity
    @ManyToMany(mappedBy = "productos")
    @ToString.Exclude
    private Set<EmpresaEntity> empresas;

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
