package com.backend.backend.Entities;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Data
@Entity
public class EmpresaProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity id_empresa;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private ProductoEntity id_producto;
}
