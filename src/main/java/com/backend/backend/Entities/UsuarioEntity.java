package com.backend.backend.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "usuario")
@Table(name = "usuario")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_usuario")
public class UsuarioEntity {
    @Id
    @Column(name = "id_usuario", nullable = false, unique = true)
    private Integer id_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String correo;
    private String contrasena;
    private LocalDate fecha_nacimiento;
    // UbicacionGeograficaEntity
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion")
    @ToString.Exclude
    private UbicacionGeograficaEntity id_ubicacion;
    // ValoracionEntity
    @OneToOne(mappedBy = "id_usuario",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            orphanRemoval = true)
    private ValoracionEntity id_valoracion;
    // PagoEntity
    @OneToMany(mappedBy = "id_usuario",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @ToString.Exclude
    private Set<PagoEntity> id_pago;
    // CarritoComprasEntity
    @JsonManagedReference
    @OneToMany(mappedBy = "id_usuario",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @ToString.Exclude
    private Set<CarritoComprasEntity> id_carrito;
    // RolEntity
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private RolEntity rol;
    // UsuarioProductoEntity
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "usuario_producto",
            joinColumns = {@JoinColumn(name = "id_usuario")},
            inverseJoinColumns = {@JoinColumn(name = "id_producto")})
    @ToString.Exclude
    private Set<ProductoEntity> productos;
    // EmpresasFavoritasEntity
    @JsonManagedReference
    @OneToMany(mappedBy = "id_usuario",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            orphanRemoval = true)
    @ToString.Exclude
    private Set<UsuarioEmpresaEntity> empresas_favoritas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return id_usuario != null && Objects.equals(id_usuario, that.id_usuario);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
