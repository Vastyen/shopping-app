package com.backend.backend.Entities;
import lombok.Data;

import javax.persistence.*;
// Relaciones Listas
@Data
@Entity
public class MetodoPagoEntity {
    @Id
    @Column(nullable = false, unique = true)
    private Integer id;
    private String metodo_pago;
    @OneToOne(mappedBy = "metodo_pago",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private PagoEntity pago;
}
