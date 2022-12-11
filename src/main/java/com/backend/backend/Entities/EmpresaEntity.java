package com.backend.backend.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity(name = "empresa")
public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Empresa", nullable = false, unique = true)
    private Integer id_empresa;
    private Integer restriccion_edad;
    @Column(nullable = false, unique = true)
    private String nombre_empresa;
    // UbicacionGeograficaEntity
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion")
    private UbicacionGeograficaEntity id_ubicacion;
    // ValoracionEntity
    @JsonIgnore
    @OneToMany(mappedBy = "id_empresa",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private Set<ValoracionEntity> valoraciones;
    // EmpresaProductoEntity
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "empresa_producto",
            joinColumns = {@JoinColumn(name = "id_empresa")},
            inverseJoinColumns = {@JoinColumn(name = "id_producto")})
    private Set<ProductoEntity> productos;
    // EmpresaTipoProducto
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "empresa_tipo_producto",
            joinColumns = {@JoinColumn(name = "id_empresa")},
            inverseJoinColumns = {@JoinColumn(name = "id_tipo_producto")})
    private Set<TipoProductoEntity> tipos_productos;
    // EmpresasFavoritasEntity
    @JsonBackReference
    @OneToMany(mappedBy = "id_empresa",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            orphanRemoval = true)
    private Set<UsuarioEmpresaEntity> empresas_favoritas;
}