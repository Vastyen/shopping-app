package com.backend.backend.Entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class RolEntity {
    @Id
    @Column(nullable = false, unique = true)
    private Integer id;
    private String nombre_rol;
    private String alias_rol;
}
