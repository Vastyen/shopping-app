package com.backend.backend.Repositories;

import com.backend.backend.Entities.CarritoComprasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoComprasRepository extends JpaRepository<CarritoComprasEntity, Integer> {
    // Queries
}
