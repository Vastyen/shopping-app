package com.backend.backend.Repositories;

import com.backend.backend.Entities.MetodoPagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPagoEntity, Integer> {
    // Queries
}
