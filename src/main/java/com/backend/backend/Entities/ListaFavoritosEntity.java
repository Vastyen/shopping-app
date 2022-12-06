package com.backend.backend.Entities;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ListaFavoritosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id_lista_fav;
    private String titulo_lista_fav;
}
