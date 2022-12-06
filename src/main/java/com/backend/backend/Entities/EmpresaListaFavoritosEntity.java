package com.backend.backend.Entities;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class EmpresaListaFavoritosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_lista_fav")
    private ListaFavoritosEntity id_lista_fav;
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity id_empresa;
}
