package com.backend.backend.Repositories;

import com.backend.backend.Entities.EmpresaEntity;
import com.backend.backend.Entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Integer> {
    // Queries
    @Query(value = "SELECT * FROM empresa WHERE restriccion_edad < 18 SUM", nativeQuery = true)
    ArrayList<EmpresaEntity> getParaEmpresasMenores(Integer edad);

}
