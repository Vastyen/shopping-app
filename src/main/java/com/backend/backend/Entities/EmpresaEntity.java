package com.backend.backend.Entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "empresa")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_empresa")
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
    @ToString.Exclude
    private UbicacionGeograficaEntity id_ubicacion;
    // ValoracionEntity
    @JsonIgnore
    @OneToMany(mappedBy = "id_empresa",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @ToString.Exclude
    private Set<ValoracionEntity> valoraciones;
    // EmpresaProductoEntity
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "empresa_producto",
            joinColumns = {@JoinColumn(name = "id_empresa")},
            inverseJoinColumns = {@JoinColumn(name = "id_producto")})
    @ToString.Exclude
    private Set<ProductoEntity> productos;
    // EmpresaTipoProducto
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "empresa_tipo_producto",
            joinColumns = {@JoinColumn(name = "id_empresa")},
            inverseJoinColumns = {@JoinColumn(name = "id_tipo_producto")})
    @ToString.Exclude
    private Set<TipoProductoEntity> tipos_productos;
    // EmpresasFavoritasEntity

    @OneToMany(mappedBy = "id_empresa",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            orphanRemoval = true)
    @ToString.Exclude
    private Set<UsuarioEmpresaEntity> empresas_favoritas;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmpresaEntity that = (EmpresaEntity) o;
        return id_empresa != null && Objects.equals(id_empresa, that.id_empresa);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}