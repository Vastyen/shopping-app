package com.backend.backend.Repositories;

import com.backend.backend.Entities.CarritoComprasEntity;
import com.backend.backend.Entities.CarritoComprasProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CarritoComprasProductoRepository extends JpaRepository<CarritoComprasProductoEntity, Integer> {
    // Queries
    @Query(value = "SELECT * FROM carrito_compras_producto WHERE id_carrito = ?1 AND cantidad != 0", nativeQuery = true)
    ArrayList<CarritoComprasProductoEntity> getProductos(Integer idCarritoCompras);
    @Query(value = "SELECT * FROM carrito_compras_producto WHERE id_carrito = ?1 AND id_producto = ?2", nativeQuery = true)
    CarritoComprasProductoEntity findUsingIdCarritoAndUsingIdProducto(Integer idCarritoCompras, Integer idProducto);


}
