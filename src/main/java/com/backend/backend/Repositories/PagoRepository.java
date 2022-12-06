package com.backend.backend.Repositories;

import com.backend.backend.Entities.PagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<PagoEntity, Integer> {
    // Queries
}
