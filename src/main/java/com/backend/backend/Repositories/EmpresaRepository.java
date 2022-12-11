package com.backend.backend.Repositories;

import com.backend.backend.Entities.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Integer> {
    // Queries
}
