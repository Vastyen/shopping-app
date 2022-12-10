package com.backend.backend.Services;

import com.backend.backend.Entities.PagoEntity;
import com.backend.backend.Repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PagoService {

    @Autowired
    PagoRepository pagoRepository;
    public PagoEntity getPagoById(Integer id_pago) {
        return pagoRepository.findById(id_pago).orElse(null);
    }

    public void savePago(PagoEntity pagoEntity) {
        pagoRepository.save(pagoEntity);
    }

    public PagoEntity createPago(PagoEntity pagoEntity) {
        return pagoRepository.save(pagoEntity);
    }

    public void deletePago(PagoEntity pagoEntity) {
        pagoRepository.delete(pagoEntity);
    }

    public ArrayList<PagoEntity> getAllPago() {
        return (ArrayList<PagoEntity>) pagoRepository.findAll();
    }
}
