package com.backend.backend.Entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "usuario")
@Table(name = "usuario")
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
    @JsonManagedReference(value = "usuario")
    @OneToOne(mappedBy = "id_usuario",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            orphanRemoval = true)
    private CarritoComprasEntity id_carrito_compras;
    // RolEntity
    @JsonBackReference(value = "rol")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    private RolEntity rol;
    // EmpresasFavoritasEntity
    @JsonManagedReference(value = "usuario")
    @OneToMany(mappedBy = "id_usuario",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            orphanRemoval = true)
    @ToString.Exclude
    private Set<UsuarioEmpresaEntity> empresas_favoritas = new HashSet<>();

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
