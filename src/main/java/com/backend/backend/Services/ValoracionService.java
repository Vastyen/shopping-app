package com.backend.backend.Services;

import com.backend.backend.Entities.ValoracionEntity;
import com.backend.backend.Repositories.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ValoracionService {

    @Autowired
    ValoracionRepository valoracionRepository;
    public ValoracionEntity getValoracionById(Integer id_valoracion) {
        return valoracionRepository.findById(id_valoracion).orElse(null);
    }

    public void saveValoracion(ValoracionEntity valoracionEntity) {
        valoracionRepository.save(valoracionEntity);
    }

    public ValoracionEntity createValoracion(ValoracionEntity valoracionEntity) {
        return valoracionRepository.save(valoracionEntity);
    }

    public void deleteValoracion(ValoracionEntity valoracionEntity) {
        valoracionRepository.delete(valoracionEntity);
    }

    public ArrayList<ValoracionEntity> getAllValoracion() {
        return (ArrayList<ValoracionEntity>) valoracionRepository.findAll();
    }
}
