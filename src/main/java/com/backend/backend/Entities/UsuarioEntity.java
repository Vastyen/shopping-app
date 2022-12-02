package com.backend.backend.Entities;

import lombok.Data;
import com.backend.backend.Entities.RolEntity;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class UsuarioEntity {
    @Id
    @Column(nullable = false, unique = true)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private RolEntity rol;
    private String nombre_usuario;
    private String apellido_usuario;
    private String correo_usuario;
    private String contrasena;
    private LocalDate fecha_nacimiento;
}
