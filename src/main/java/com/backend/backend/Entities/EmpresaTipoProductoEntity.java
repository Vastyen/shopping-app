package com.backend.backend.Entities;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class EmpresaTipoProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id_empresa_tipo_producto;
    @ManyToOne
    @JoinColumn(name = "id_tipo_producto")
    private TipoProductoEmpresaEntity id_tipo_producto;
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity id_empresa;
}
