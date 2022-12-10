package com.backend.backend.Repositories;

import com.backend.backend.Entities.EmpresaEntity;
import com.backend.backend.Entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    // Queries
}
