package com.backend.backend.Services;

import com.backend.backend.Entities.ProductoEntity;
import com.backend.backend.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.SortedSet;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    CarritoComprasService carritoComprasService;

    public void updateProducto(ProductoEntity productoUpdated) {
        productoRepository.save(productoUpdated);
    }


    public ArrayList<ProductoEntity> getAllProductos() {
        return (ArrayList<ProductoEntity>) productoRepository.findAll();
    }

    public ProductoEntity getProductoById(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    public ProductoEntity createProducto(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    public void deleteProductoById(Integer id_producto) {
        productoRepository.deleteById(id_producto);
    }

    public ArrayList<ProductoEntity> getOrdenProductos(Integer IdEmpresa) {
        return productoRepository.getOrderedByVentas_producto(IdEmpresa);
    }

}
