package com.backend.backend.Services;

import com.backend.backend.Entities.PermisoEntity;
import com.backend.backend.Repositories.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PermisoService {

    @Autowired
    PermisoRepository permisoRepository;
    public PermisoEntity getPermisoById(Integer id_permiso) {
        return permisoRepository.findById(id_permiso).orElse(null);
    }

    public void savePermiso(PermisoEntity permisoEntity) {
        permisoRepository.save(permisoEntity);
    }

    public PermisoEntity createPermiso(PermisoEntity permisoEntity) {
        return permisoRepository.save(permisoEntity);
    }

    public void deletePermiso(PermisoEntity permisoEntity) {
        permisoRepository.delete(permisoEntity);
    }

    public ArrayList<PermisoEntity> getAllPermisos() {
        return (ArrayList<PermisoEntity>) permisoRepository.findAll();
    }
}
