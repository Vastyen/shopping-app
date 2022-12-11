package com.backend.backend.Services;

import com.backend.backend.Entities.CarritoComprasEntity;
import com.backend.backend.Entities.CarritoComprasProductoEntity;
import com.backend.backend.Entities.ProductoEntity;
import com.backend.backend.Repositories.CarritoComprasProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarritoComprasProductoService {

    @Autowired
    CarritoComprasProductoRepository carritoComprasProductoRepository;

    public ArrayList<CarritoComprasProductoEntity> getAllCarritoComprasProducto() {
        return (ArrayList<CarritoComprasProductoEntity>) carritoComprasProductoRepository.findAll();
    }

    public ArrayList<CarritoComprasProductoEntity> getProductosCarritoComprasByIdUsuario(Integer idUsuario) {
        return carritoComprasProductoRepository.getProductos(idUsuario);
    }

    public ArrayList<CarritoComprasProductoEntity> getProductosByIdCarritoCompras(Integer idCarrito) {
        return carritoComprasProductoRepository.getProductos(idCarrito);
    }

}
