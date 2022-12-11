package com.backend.backend.Controllers;

import com.backend.backend.Entities.CarritoComprasProductoEntity;
import com.backend.backend.Entities.ProductoEntity;
import com.backend.backend.Services.CarritoComprasProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/carritoComprasProducto")
public class CarritoComprasProductoController {

    @Autowired
    CarritoComprasProductoService carritoComprasProductoService;

    @GetMapping("/getAllCarritoComprasProducto")
    public ResponseEntity<ArrayList<CarritoComprasProductoEntity>> getAllCarritoComprasProducto() {
        ArrayList<CarritoComprasProductoEntity> carritoComprasProductoEntities = carritoComprasProductoService.getAllCarritoComprasProducto();
        if (carritoComprasProductoEntities == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carritoComprasProductoEntities);
    }
/*
    @GetMapping("/getProductosCarritoComprasByIdUsuario/{id_usuario}")
    public ResponseEntity<ArrayList<CarritoComprasProductoEntity>> getProductosCarritoComprasByIdUsuario(@PathVariable("id_usuario") Integer id_usuario) {
        ArrayList<CarritoComprasProductoEntity> carritoComprasProductoEntities = carritoComprasProductoService.getProductosCarritoComprasByIdUsuario(id_usuario);
        if (carritoComprasProductoEntities == null) {
            return ResponseEntity.notFound().build();
        }
        ArrayList<ProductoEntity> productoEntities = new ArrayList<>();
        for(CarritoComprasProductoEntity carritoComprasProductoEntity : carritoComprasProductoEntities) {
            productoEntities.add(carritoComprasProductoEntity.getId_producto());
        }
        return ResponseEntity.ok(carritoComprasProductoEntities);
    }
*/



}
