package com.backend.backend.Services;

import com.backend.backend.Entities.TipoProductoEntity;
import com.backend.backend.Repositories.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TipoProductoService {

    @Autowired
    TipoProductoRepository tipoProductoRepository;
    public TipoProductoEntity getTipoProductoById(Integer id_tipo_producto) {
        return tipoProductoRepository.findById(id_tipo_producto).orElse(null);
    }

    public void saveTipoProducto(TipoProductoEntity tipoProductoEntity) {
        tipoProductoRepository.save(tipoProductoEntity);
    }

    public TipoProductoEntity createTipoProducto(TipoProductoEntity tipoProductoEntity) {
        return tipoProductoRepository.save(tipoProductoEntity);
    }

    public void deleteTipoProducto(TipoProductoEntity tipoProductoEntity) {
        tipoProductoRepository.delete(tipoProductoEntity);
    }

    public ArrayList<TipoProductoEntity> getAllTipoProducto() {
        return (ArrayList<TipoProductoEntity>) tipoProductoRepository.findAll();
    }
}
