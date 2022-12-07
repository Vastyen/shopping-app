package com.backend.backend.Services;

import com.backend.backend.Entities.CarritoComprasEntity;
import com.backend.backend.Entities.ProductoEntity;
import com.backend.backend.Repositories.CarritoComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoComprasService {

    @Autowired
    CarritoComprasRepository carritoComprasRepository;

    public CarritoComprasEntity getCarritoComprasById(Integer id_carrito) {
        return carritoComprasRepository.findById(id_carrito).orElse(null);
    }


    public CarritoComprasEntity deleteCarritoComprasById(Integer id_carrito) {
        CarritoComprasEntity carritoComprasEntity = carritoComprasRepository.findById(id_carrito).orElse(null);
        if (carritoComprasEntity == null) {
            return null;
        }
        carritoComprasRepository.deleteById(id_carrito);
        return carritoComprasEntity;
    }

    public void saveCarritoCompras(CarritoComprasEntity carritoComprasEntity) {
        carritoComprasRepository.save(carritoComprasEntity);
    }

    public CarritoComprasEntity createCarritoCompras(CarritoComprasEntity carritoComprasEntity) {
        return carritoComprasRepository.save(carritoComprasEntity);
    }
}
