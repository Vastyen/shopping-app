package com.backend.backend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

// Relaciones Listas
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "pago")
@Table(name = "pago")
public class PagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago", nullable = false, unique = true)
    private Integer id;
    private Float monto;
    // MetodoPagoEntity
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    @ToString.Exclude
    private MetodoPagoEntity id_metodo_pago;
    // UsuarioEntity
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity id_usuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PagoEntity that = (PagoEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
