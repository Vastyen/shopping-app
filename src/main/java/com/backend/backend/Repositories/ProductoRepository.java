package com.backend.backend.Repositories;

import com.backend.backend.Entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {
    // Queries

    @Query(value = "SELECT * FROM producto WHERE id_producto IN (SELECT id_producto FROM empresa_producto WHERE id_empresa = ?1) ORDER BY ventas_producto DESC", nativeQuery = true)
    ArrayList<ProductoEntity> getOrderedByVentas_producto(Integer idEmpresa);


}
