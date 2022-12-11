package com.backend.backend.Repositories;

import com.backend.backend.Entities.EmpresaEntity;
import com.backend.backend.Entities.UsuarioEmpresaEntity;
import com.backend.backend.Entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Set;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    // Queries
    UsuarioEntity findByCorreoAndContrasena(String Correo,String contrasena);

}
