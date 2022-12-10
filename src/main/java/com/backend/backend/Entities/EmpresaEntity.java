package com.backend.backend.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
public class EmpresaEntity {
    @Id
    @Column(name = "id_Empresa", nullable = false, unique = true)
    private Integer id;
    private Integer restriccion_edad;
    private String nombre_empresa;
    // UbicacionGeograficaEntity
    @OneToOne
    @JoinColumn(name = "id_ubicacion")
    private UbicacionGeograficaEntity id_ubicacion;
    // ListaFavoritosEntity
    @OneToMany(mappedBy = "id_empresa",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
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
    @OneToMany(mappedBy = "id_empresa",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            orphanRemoval = true)
    private Set<UsuarioEmpresaEntity> empresas_favoritas;

    // Método extra
    public Set<UsuarioEntity> getUsuariosFavoritos() {
        return getEmpresas_favoritas()
                .stream()
                .map(UsuarioEmpresaEntity::getId_usuario)
                .collect(Collectors.toSet());
    }
}