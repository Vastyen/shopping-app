package com.backend.backend.Repositories;

import com.backend.backend.Entities.UbicacionGeograficaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UbicacionGeograficaRepository extends JpaRepository<UbicacionGeograficaEntity, Integer> {
    ArrayList<UbicacionGeograficaEntity> findByRegion(String region);

    ArrayList<UbicacionGeograficaEntity> findByComuna(String comuna);

    ArrayList<UbicacionGeograficaEntity> findByDireccion(String direccion);
// Queries
}
