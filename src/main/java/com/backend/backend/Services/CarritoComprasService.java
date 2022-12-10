package com.backend.backend.Services;

import com.backend.backend.Entities.CarritoComprasEntity;
import com.backend.backend.Entities.ProductoEntity;
import com.backend.backend.Repositories.CarritoComprasRepository;
import com.backend.backend.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarritoComprasService {

    @Autowired
    CarritoComprasRepository carritoComprasRepository;
    @Autowired
    ProductoRepository productoRepository;

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
    public CarritoComprasEntity createCarritoCompras(CarritoComprasEntity carritoComprasEntity) {
        return carritoComprasRepository.save(carritoComprasEntity);
    }
    public void updateCarritoCompras(CarritoComprasEntity carritoComprasEntity, Integer id) {
        CarritoComprasEntity carritoComprasEntity1 = carritoComprasRepository.findById(id).orElse(null);
        if (carritoComprasEntity1 == null) {
            return;
        }
        carritoComprasEntity1.setProductos(carritoComprasEntity.getProductos());
        carritoComprasEntity1.setId_usuario(carritoComprasEntity.getId_usuario());
        carritoComprasRepository.save(carritoComprasEntity1);
    }
    public CarritoComprasEntity saveCarritoCompras(CarritoComprasEntity carritoComprasEntity) {
        CarritoComprasEntity newCarrito = new CarritoComprasEntity();
        newCarrito.setId_usuario(carritoComprasEntity.getId_usuario());
        newCarrito.getProductos().
                addAll(carritoComprasEntity
                        .getProductos()
                        .stream()
                        .peek(productoEntity -> productoEntity.getCarritosCompra().
                                add(newCarrito)).collect(Collectors.toSet()));
        return carritoComprasRepository.save(newCarrito);

    }

    public CarritoComprasEntity addProductoToCarritoCompras(Integer idCarrito, Integer idProducto) {
        Set<ProductoEntity> Productos = null;
        CarritoComprasEntity Carrito = carritoComprasRepository.findById(idCarrito).orElse(null);
        if (Carrito == null) {
            return null;
        }
        ProductoEntity Producto = productoRepository.findById(idProducto).orElse(null);
        if (Producto == null) {
            return null;
        }
        Productos = Carrito.getProductos();
        Productos.add(productoRepository.findById(idProducto).orElse(null));
        Carrito.setProductos(Productos);
        return carritoComprasRepository.save(Carrito);
    }

}
