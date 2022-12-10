package com.backend.backend.Services;

import com.backend.backend.Entities.RolEntity;
import com.backend.backend.Repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public RolEntity getRolById(Integer id_rol) {
        return rolRepository.findById(id_rol).orElse(null);
    }

    public void saveRol(RolEntity rolEntity) {
        rolRepository.save(rolEntity);
    }

    public RolEntity createRol(RolEntity rolEntity) {
        return rolRepository.save(rolEntity);
    }

    public void deleteRol(RolEntity rolEntity) {
        rolRepository.delete(rolEntity);
    }

    public ArrayList<RolEntity> getAllRoles() {
        return (ArrayList<RolEntity>) rolRepository.findAll();
    }
}
