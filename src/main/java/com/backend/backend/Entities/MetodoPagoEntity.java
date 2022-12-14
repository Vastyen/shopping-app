package com.backend.backend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

// Relaciones Listas
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "metodo_pago")
@Table(name = "metodo_pago")
public class MetodoPagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo_pago", nullable = false, unique = true)
    private Integer id;
    private String metodo_pago;
    @JsonIgnore
    @OneToMany(mappedBy = "id_metodo_pago", fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.MERGE},
                orphanRemoval = true)
    @ToString.Exclude
    private Set<PagoEntity> pagos;
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
