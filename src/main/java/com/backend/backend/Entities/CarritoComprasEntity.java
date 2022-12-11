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
@Entity(name = "carrito_compras")
@Table(name = "carrito_compras")
public class CarritoComprasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito", nullable = false, unique = true)
    private Integer id;
    // UsuarioEntity
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity id_usuario;
    // ProductoCarritoEntity
    @JsonManagedReference
    @OneToMany(mappedBy = "id_carrito",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @ToString.Exclude
    private Set<CarritoComprasProductoEntity> productos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CarritoComprasEntity that = (CarritoComprasEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
