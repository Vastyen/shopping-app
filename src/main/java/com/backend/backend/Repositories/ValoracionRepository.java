package com.backend.backend.Repositories;

import com.backend.backend.Entities.ValoracionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValoracionRepository extends JpaRepository<ValoracionEntity, Integer> {
    // Queries
    Integer countByEmpresaId(Integer empresaId);
}
