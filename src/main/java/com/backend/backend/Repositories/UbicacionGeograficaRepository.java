package com.backend.backend.Repositories;

import com.backend.backend.Entities.UbicacionGeograficaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionGeograficaRepository extends JpaRepository<UbicacionGeograficaEntity, Integer> {
// Queries
}
