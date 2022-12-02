package com.backend.backend.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
