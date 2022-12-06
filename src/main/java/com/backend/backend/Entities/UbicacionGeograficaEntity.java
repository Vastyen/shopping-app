package com.backend.backend.Entities;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;
// Relaciones Completas
@Data
@Entity
public class UbicacionGeograficaEntity {
    @Id
    @Column(name = "id_ubicacion", nullable = false, unique = true)
    private Integer id;
    private String region;
    private String comuna;
    private String direccion;
    @OneToOne(mappedBy = "id_ubicacion",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private EmpresaEntity id_empresa;
    @OneToOne(mappedBy = "id_ubicacion",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY, orphanRemoval = true)
    private UsuarioEntity id_usuario;

}
