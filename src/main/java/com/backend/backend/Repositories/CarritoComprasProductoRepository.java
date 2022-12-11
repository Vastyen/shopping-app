package com.backend.backend.Repositories;

import com.backend.backend.Entities.CarritoComprasProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CarritoComprasProductoRepository extends JpaRepository<CarritoComprasProductoEntity, Integer> {
    // Queries
    @Query(value = "SELECT * FROM carrito_compras_productos WHERE id_carrito_compras = ?1", nativeQuery = true)
    CarritoComprasProductoEntity getCarritoComprasProducto(Integer idCarritoCompras);
}
