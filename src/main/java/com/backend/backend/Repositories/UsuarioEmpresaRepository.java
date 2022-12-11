package com.backend.backend.Repositories;

import com.backend.backend.Entities.EmpresaEntity;
import com.backend.backend.Entities.UsuarioEmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioEmpresaRepository extends JpaRepository<UsuarioEmpresaEntity, Integer> {

    // Queries
    @Query(value = "SELECT * FROM empresas_favoritas WHERE id_usuario = ?1 AND id_empresa = ?2", nativeQuery = true)
    UsuarioEmpresaEntity getUsuarioEmpresa(Integer idUsuario, Integer idEmpresa);
    @Query(value = "SELECT * FROM empresas_favoritas WHERE id_usuario = ?1 AND favorito IS TRUE", nativeQuery = true)
    ArrayList<UsuarioEmpresaEntity> getFavoritos(Integer idUsuario);

}
