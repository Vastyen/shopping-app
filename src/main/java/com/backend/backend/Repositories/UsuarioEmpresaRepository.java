package com.backend.backend.Repositories;

import com.backend.backend.Entities.EmpresaEntity;
import com.backend.backend.Entities.UsuarioEmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioEmpresaRepository extends JpaRepository<UsuarioEmpresaEntity, Integer> {
    UsuarioEmpresaEntity findById_usuarioAndId_empresa(Integer idUsuario, Integer idEmpresa);
    // Queries
}
