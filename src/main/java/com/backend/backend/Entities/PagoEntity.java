package com.backend.backend.Entities;
import lombok.Data;

import javax.persistence.*;
// Relaciones Listas
@Data
@Entity
public class PagoEntity {
    @Id
    @Column(name = "id_pago", nullable = false, unique = true)
    private Integer id;
    private Float monto;
    @OneToOne
    @JoinColumn(name = "metodo_pago")
    private MetodoPagoEntity metodo_pago;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity id_usuario;
}
