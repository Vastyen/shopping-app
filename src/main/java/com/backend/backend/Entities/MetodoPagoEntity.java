package com.backend.backend.Entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

// Relaciones Listas
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "metodo_pago")
@Table(name = "metodo_pago")
public class MetodoPagoEntity {
    @Id
    @Column(nullable = false, unique = true)
    private Integer id;
    private String metodo_pago;
    @OneToOne(mappedBy = "metodo_pago",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @ToString.Exclude
    private PagoEntity pago;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MetodoPagoEntity that = (MetodoPagoEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
