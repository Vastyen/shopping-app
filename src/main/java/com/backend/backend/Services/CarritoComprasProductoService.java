package com.backend.backend.Services;

import com.backend.backend.Entities.CarritoComprasEntity;
import com.backend.backend.Entities.CarritoComprasProductoEntity;
import com.backend.backend.Entities.ProductoEntity;
import com.backend.backend.Repositories.CarritoComprasProductoRepository;
import com.backend.backend.Repositories.CarritoComprasRepository;
import com.backend.backend.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarritoComprasProductoService {

    @Autowired
    CarritoComprasProductoRepository carritoComprasProductoRepository;
    @Autowired
    CarritoComprasRepository carritoComprasRepository;
    @Autowired
    ProductoRepository productoRepository;


    public ArrayList<CarritoComprasProductoEntity> getAllCarritoComprasProducto() {
        return (ArrayList<CarritoComprasProductoEntity>) carritoComprasProductoRepository.findAll();
    }

    public ArrayList<CarritoComprasProductoEntity> getProductosCarritoComprasByIdUsuario(Integer idUsuario) {
        return carritoComprasProductoRepository.getProductos(idUsuario);
    }

    public ArrayList<CarritoComprasProductoEntity> getProductosByIdCarritoCompras(Integer idCarrito) {
        return carritoComprasProductoRepository.getProductos(idCarrito);
    }

    public CarritoComprasProductoEntity addProductoToMyCart(Integer idProducto, Integer idCarrito, Integer cantidad) {
        CarritoComprasProductoEntity carritoComprasProductoEntity = carritoComprasProductoRepository.findUsingIdCarritoAndUsingIdProducto(idCarrito, idProducto);
        if(carritoComprasProductoEntity == null) {
            carritoComprasProductoEntity = new CarritoComprasProductoEntity();
            carritoComprasProductoEntity.setId_carrito(carritoComprasRepository.findById(idCarrito).orElse(null));
            carritoComprasProductoEntity.setId_producto(productoRepository.findById(idProducto).orElse(null));
            carritoComprasProductoEntity.setCantidad(cantidad);
            carritoComprasProductoRepository.save(carritoComprasProductoEntity);
        } else {
            carritoComprasProductoEntity.setCantidad(carritoComprasProductoEntity.getCantidad() + cantidad);
            carritoComprasProductoRepository.save(carritoComprasProductoEntity);
        }
        return carritoComprasProductoRepository.save(carritoComprasProductoEntity);
    }
}
