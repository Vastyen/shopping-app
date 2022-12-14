package com.backend.backend.Services;

import com.backend.backend.Entities.UbicacionGeograficaEntity;
import com.backend.backend.Entities.UsuarioEntity;
import com.backend.backend.Repositories.UbicacionGeograficaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class UbicacionGeograficaService {

    @Autowired
    UbicacionGeograficaRepository ubicacionGeograficaRepository;

    public UbicacionGeograficaEntity getUbicacionGeograficaById(Integer id_ubicacion_geografica) {
        return ubicacionGeograficaRepository.findById(id_ubicacion_geografica).orElse(null);
    }

    public void saveUbicacionGeografica(UbicacionGeograficaEntity ubicacionGeograficaEntity) {
        ubicacionGeograficaRepository.save(ubicacionGeograficaEntity);
    }

    public UbicacionGeograficaEntity createUbicacionGeografica(UbicacionGeograficaEntity ubicacionGeograficaEntity) {
        return ubicacionGeograficaRepository.save(ubicacionGeograficaEntity);
    }

    public void deleteUbicacionGeografica(UbicacionGeograficaEntity ubicacionGeograficaEntity) {
        ubicacionGeograficaRepository.delete(ubicacionGeograficaEntity);
    }

    public ArrayList<UbicacionGeograficaEntity> getAllUbicacionGeografica() {
        return (ArrayList<UbicacionGeograficaEntity>) ubicacionGeograficaRepository.findAll();
    }

    public ArrayList<UbicacionGeograficaEntity> getUbicacionGeograficaByRegion(String region) {
        return ubicacionGeograficaRepository.findByRegion(region);
    }

    public ArrayList<UbicacionGeograficaEntity> getUbicacionGeograficaByComuna(String comuna) {
        return ubicacionGeograficaRepository.findByComuna(comuna);
    }

    public ArrayList<UbicacionGeograficaEntity> getUbicacionGeograficaByDireccion(String direccion) {
        return ubicacionGeograficaRepository.findByDireccion(direccion);
    }

}
