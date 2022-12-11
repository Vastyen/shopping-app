package com.backend.backend.Controllers;

import com.backend.backend.Entities.ProductoEntity;
import com.backend.backend.Services.ProductoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/producto")
public class ProductoController {


    @Autowired
    ProductoService productoService;

    @GetMapping("/getAllProductos")
    public ResponseEntity<ArrayList<ProductoEntity>> getAllProductos() {
        ArrayList<ProductoEntity> productos = productoService.getAllProductos();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }
    @GetMapping("/getProductoById/{id}")
    public ResponseEntity<ProductoEntity> getProductoById(@PathVariable("id") Integer id) {
        ProductoEntity producto = productoService.getProductoById(id);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }
    @PutMapping("/updateProductoById/{id_producto}")
    public ResponseEntity<ProductoEntity> updateProductoById(@PathVariable("id_producto") Integer id_producto, @RequestBody ProductoEntity producto) {
        ProductoEntity productoUpdated = productoService.getProductoById(id_producto);
        if(productoUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        productoUpdated.setNombre_producto(producto.getNombre_producto());
        productoUpdated.setDescripcion(producto.getDescripcion());
        productoUpdated.setPrecio(producto.getPrecio());
        productoUpdated.setStock(producto.getStock());
        productoUpdated.setTipo(producto.getTipo());
        productoUpdated.setVentas_producto(producto.getVentas_producto());
        productoUpdated.setCarritos(producto.getCarritos());
        productoService.updateProducto(productoUpdated);
        return ResponseEntity.ok(productoUpdated);
    }
    @PostMapping("/createProducto")
    public ResponseEntity<ProductoEntity> createProducto(@RequestBody ProductoEntity producto) {
        ProductoEntity productoCreated = productoService.createProducto(producto);
        if (productoCreated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productoCreated);
    }
    @DeleteMapping("/deleteProductoById/{id_producto}")
    public ResponseEntity<ProductoEntity> deleteProductoById(@PathVariable("id_producto") Integer id_producto) {
        ProductoEntity productoDeleted = productoService.getProductoById(id_producto);
        if (productoDeleted == null) {
            return ResponseEntity.notFound().build();
        }
        productoService.deleteProductoById(id_producto);
        return ResponseEntity.ok(productoDeleted);
    }

    @GetMapping("/getProductosMasVendidosByIdEmpresa/{id_empresa}")
    public ResponseEntity<ArrayList<ProductoEntity>> getProductosMasVendidosByIdEmpresa(@PathVariable("id_empresa") Integer id_empresa) {
        ArrayList<ProductoEntity> productos = productoService.getOrdenProductos(id_empresa);
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }
}
