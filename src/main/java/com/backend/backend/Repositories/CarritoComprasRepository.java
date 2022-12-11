package com.backend.backend.Repositories;

import com.backend.backend.Entities.CarritoComprasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoComprasRepository extends JpaRepository<CarritoComprasEntity, Integer> {
    @Query(value = "SELECT * FROM carrito_compras WHERE id_usuario = ?1", nativeQuery = true)
    CarritoComprasEntity findUsingIdUsuario(Integer idUsuario);
    // Queries
}
