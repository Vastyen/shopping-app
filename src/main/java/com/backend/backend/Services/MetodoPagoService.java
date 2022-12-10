package com.backend.backend.Services;

import com.backend.backend.Entities.MetodoPagoEntity;
import com.backend.backend.Repositories.MetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MetodoPagoService {

    @Autowired
    MetodoPagoRepository metodoPagoRepository;
    public MetodoPagoEntity getMetodoPagoById(Integer id_metodo_pago) {
        return metodoPagoRepository.findById(id_metodo_pago).orElse(null);
    }

    public void deleteMetodoPago(MetodoPagoEntity metodoPagoEntity) {
        metodoPagoRepository.delete(metodoPagoEntity);
    }

    public MetodoPagoEntity createMetodoPago(MetodoPagoEntity metodoPagoEntity) {
        return metodoPagoRepository.save(metodoPagoEntity);
    }

    public void saveMetodoPago(MetodoPagoEntity metodoPagoEntity) {
        metodoPagoRepository.save(metodoPagoEntity);
    }

    public ArrayList<MetodoPagoEntity> getAllMetodoPago() {
        return (ArrayList<MetodoPagoEntity>) metodoPagoRepository.findAll();
    }
}
