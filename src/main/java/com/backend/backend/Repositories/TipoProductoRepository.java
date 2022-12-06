package com.backend.backend.Repositories;

import com.backend.backend.Entities.TipoProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProductoEntity, Integer> {
    // Queries
}
