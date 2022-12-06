package com.backend.backend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
public class UsuarioEntity {
    @Id
    @Column(nullable = false, unique = true)
    private Integer id_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String correo_usuario;
    private String contrasena;
    private LocalDate fecha_nacimiento;
    // UbicacionGeograficaEntity
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion")
    private UbicacionGeograficaEntity id_ubicacion;
    // ValoracionEntity
    @OneToOne(mappedBy = "id_usuario",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private ValoracionEntity id_valoracion;
    // PagoEntity
    @OneToMany(mappedBy = "id_usuario",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private Set<PagoEntity> id_pago;
    // CarritoComprasEntity
    @OneToMany(mappedBy = "id_usuario",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private Set<CarritoComprasEntity> id_carrito;
    // RolEntity
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
    private Set<ProductoEntity> productos;
    // EmpresasFavoritasEntity
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "empresas_favoritas",
            joinColumns = {@JoinColumn(name = "id_usuario")},
            inverseJoinColumns = {@JoinColumn(name = "id_empresa")})
    private Set<EmpresaEntity> empresas;
}
