package com.backend.backend.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class TipoProductoEntity {
    @Id
    @Column(name = "id_TipoProducto", nullable = false, unique = true)
    private Integer id;
    private String nombre_tipo;
    // EmpresaTipoProducto
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            mappedBy = "tipos_productos")
    private Set<EmpresaEntity> empresas;

}
