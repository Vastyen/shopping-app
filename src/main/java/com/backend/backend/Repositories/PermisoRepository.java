package com.backend.backend.Repositories;

import com.backend.backend.Entities.PermisoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepository extends JpaRepository<PermisoEntity, Integer> {
    // Queries
}
